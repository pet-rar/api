package com.project.pet.dto.Usuario;

import com.project.pet.model.UserTipo;

public record UsuarioFindAllDTO(Integer id, String cpf, String nome, String email, UserTipo tipo) {
}