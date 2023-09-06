package com.project.pet.service;

import java.util.List;

import com.project.pet.model.Usuario;

public interface UsuarioService {

	// Save operation
		Usuario saveUsuario(Usuario usuario);
	 
	    // Read operation
	    List<Usuario> fetchUsuarioList();
	 
	    // Update operation
	    Usuario updateUsuario(Usuario usuario);
	 
	    // Delete operation
	    void deleteUsuarioById(Long Id);
}
