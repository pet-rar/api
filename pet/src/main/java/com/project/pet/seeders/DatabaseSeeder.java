package com.project.pet.seeders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.pet.dto.Usuario.UsuarioSaveDTO;
import com.project.pet.dto.Usuario.UsuarioSaveWithIdDTO;
import com.project.pet.model.AnimalTipo;
import com.project.pet.model.Animal;
import com.project.pet.model.AnimalPorte;
import com.project.pet.model.UserTipo;
import com.project.pet.model.Usuario;
import com.project.pet.repository.AnimalRepository;
import com.project.pet.repository.UsuarioRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AnimalRepository animalRepository;
    
    private final ObjectMapper objectMapper = new ObjectMapper();    
    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Override
    public void run(String... args) throws Exception {
        objectMapper.registerModule(new JavaTimeModule());
        seedUsuarios();
        seedAnimais();        
    }

    private void seedUsuarios() {
        if (usuarioRepository.count() == 0) {
            try {                
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("usuarios.json");
                List<UsuarioSaveDTO> usuarios = objectMapper.readValue(inputStream, new TypeReference<List<UsuarioSaveDTO>>() {});
                
                logger.info("Number of usuarios read from JSON file: {}", usuarios.size());
                
                for (UsuarioSaveDTO usuarioSaveDTO : usuarios) {
                    Usuario usuarioSeed = new Usuario(usuarioSaveDTO);
                    usuarioSeed.setSenha(new BCryptPasswordEncoder().encode(usuarioSaveDTO.senha()));
                    usuarioRepository.save(usuarioSeed);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
      
    private void seedAnimais() {
        if (animalRepository.count() == 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate data_nascimento = LocalDate.parse("2000-01-01", formatter);

            UsuarioSaveWithIdDTO usuario = new UsuarioSaveWithIdDTO(1, "Admin", "999.999.999-99", data_nascimento, "(99) 99999-9999", UserTipo.FUNCIONARIO, "admin@email.com", "Admin@123");
            Usuario usuarioSeed = new Usuario(usuario);

            Animal animalSeed = new Animal(1, "Animal", data_nascimento, "especie", "raca", AnimalTipo.MASCULINO, AnimalPorte.MEDIO, "cor", 5.5, usuarioSeed);

            animalRepository.save(animalSeed);
        }
    }
}
