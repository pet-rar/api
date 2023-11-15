package com.project.pet.seeders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.pet.dto.Animal.AnimalSaveDTO;
import com.project.pet.dto.Usuario.UsuarioDTO;
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

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AnimalRepository animalRepository;
    
    private final ObjectMapper objectMapper = new ObjectMapper();    
    
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
            try {                
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("animais.json");
                List<AnimalSaveDTO> animais = objectMapper.readValue(inputStream, new TypeReference<List<AnimalSaveDTO>>() {});                
                                
                for (AnimalSaveDTO animalSaveDTO : animais) {
                    UsuarioDTO usuarioDTO = usuarioRepository.findUsuario(animalSaveDTO.tutor_id());
                    Usuario usuario = new Usuario(usuarioDTO);
                    Animal animalSeed = new Animal(animalSaveDTO, usuario);
                    
                    animalRepository.save(animalSeed);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
