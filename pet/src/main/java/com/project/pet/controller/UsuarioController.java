package com.project.pet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioRegisterDTO;
import com.project.pet.model.Usuario;
import com.project.pet.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService UsuarioService;

	@PostMapping("/usuario/register")
	public ResponseEntity saveUsuario(@Valid @RequestBody UsuarioRegisterDTO Usuario) {
		UsuarioService.saveUsuario(Usuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/usuario")
	public List<UsuarioFindAllDTO> listUsuario() {
		return UsuarioService.fetchUsuarioList();
	}

	@PostMapping("/usuarioUpdate")
	public Usuario updateUsuario(Usuario Usuario) {
		return UsuarioService.updateUsuario(Usuario);
	}

	@DeleteMapping("/usuario/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long Id) {
		UsuarioService.deleteUsuarioById(Id);
		return "Deleted Successfully";
	}
}
