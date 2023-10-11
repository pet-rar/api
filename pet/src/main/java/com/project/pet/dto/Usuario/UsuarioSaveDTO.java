package com.project.pet.dto.Usuario;

import com.project.pet.dto.Endereco.EnderecoSaveDTO;

public record UsuarioSaveDTO(UsuarioDTO usuario, EnderecoSaveDTO endereco) {
}