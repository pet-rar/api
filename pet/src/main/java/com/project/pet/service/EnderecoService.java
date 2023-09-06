package com.project.pet.service;

import java.util.List;

import com.project.pet.model.Endereco;

public interface EnderecoService {

	
	// Save operation
	Endereco saveEndereco(Endereco endereco);
 
    // Read operation
    List<Endereco> fetchEnderecoList();
 
    // Update operation
    Endereco updateEndereco(Endereco endereco);
 
    // Delete operation
    void deleteEnderecoById(Long Id);
}
