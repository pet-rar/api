package com.project.pet.dto.Usuario;

import com.project.pet.dto.Endereco.EnderecoDTO;

public record UsuarioUpdateDTO(UsuarioSaveWithIdDTO usuario, EnderecoDTO endereco) {}
