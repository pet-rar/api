package com.project.pet.dto.Usuario;

import java.time.LocalDate;

import com.project.pet.dto.Endereco.EnderecoDTO;
import com.project.pet.model.UserTipo;

public record UsuarioDTO(Integer id, String nome, String cpf, LocalDate dataNascimento, String telefone, UserTipo tipo, String email, Integer id_endereco, String logradouro, String bairro, String cidade, String estado, String cep) {
}