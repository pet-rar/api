package com.project.pet.seeders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.pet.dto.Usuario.UsuarioSaveDTO;
import com.project.pet.model.UserTipo;
import com.project.pet.model.Usuario;
import com.project.pet.repository.UsuarioRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		seedUsuarios();
	}

	private void seedUsuarios() {
		if (usuarioRepository.count() == 0) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dataNascimento = LocalDate.parse("2000-01-01", formatter);
			
			UsuarioSaveDTO usuarioSaveDTO = new UsuarioSaveDTO("Admin", "999.999.999-99", dataNascimento, "(99) 99999-9999", UserTipo.FUNCIONARIO, "admin@email.com", "Admin@123");
            Usuario usuarioSeed = new Usuario(usuarioSaveDTO);
            usuarioSeed.setSenha(new BCryptPasswordEncoder().encode(usuarioSaveDTO.senha()));
            
            usuarioRepository.save(usuarioSeed);
		}
	}
}
