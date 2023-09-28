package com.project.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Usuario;
import com.project.pet.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> fetchUsuarioList() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		

		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuarioById(Long Id) {
		
		usuarioRepository.deleteById(Id);
		
	}



}
