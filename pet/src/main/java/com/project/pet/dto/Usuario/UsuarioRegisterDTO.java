package com.project.pet.dto.Usuario;

import com.project.pet.dto.Endereco.EnderecoSaveDTO;

public record UsuarioRegisterDTO(UsuarioSaveDTO usuario, EnderecoSaveDTO endereco) {}
