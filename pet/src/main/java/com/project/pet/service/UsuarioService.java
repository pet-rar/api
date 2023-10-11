package com.project.pet.service;

import java.util.List;

import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioSaveDTO;
import com.project.pet.model.Usuario;

public interface UsuarioService {
	// Save operation
	Usuario saveUsuario(UsuarioSaveDTO usuario);
	 
	// Read operation
	List<UsuarioFindAllDTO> fetchUsuarioList();
	 
	// Update operation
	Usuario updateUsuario(Usuario usuario);
	 
	// Delete operation
	void deleteUsuarioById(Long Id);
	
	Usuario findById(Long Id);
}
