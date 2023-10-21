package com.project.pet.service;

import java.util.List;

import com.project.pet.model.Endereco;

public interface EnderecoService {	
    Endereco saveEndereco(Endereco endereco);
 
    List<Endereco> fetchEnderecoList();

    Endereco updateEndereco(Endereco endereco);
 
    void deleteEnderecoById(Long Id);
}
