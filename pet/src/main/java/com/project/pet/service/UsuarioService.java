package com.project.pet.service;

import java.util.List;

import com.project.pet.dto.Usuario.UsuarioDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioRegisterDTO;
import com.project.pet.dto.Usuario.UsuarioUpdateDTO;
import com.project.pet.model.Usuario;

public interface UsuarioService {
	// Save operation
	Usuario saveUsuario(UsuarioRegisterDTO usuario);
	 
	// Read operation
	List<UsuarioFindAllDTO> fetchUsuarioList();
	
	// Read operation
	UsuarioDTO fetchUsuario(long id);
	 
	// Update operation
	Usuario updateUsuario(UsuarioUpdateDTO usuario);
	 
	// Delete operation
	void deleteUsuarioById(Long Id);
	
	Usuario findById(Long Id);
}
