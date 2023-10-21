package com.project.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Endereco;
import com.project.pet.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService{
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public List<Endereco> fetchEnderecoList() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco updateEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deleteEnderecoById(Long Id) {
        enderecoRepository.deleteById(Id);
    }
}
