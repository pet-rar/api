package com.project.pet.dto.Usuario;

import com.project.pet.model.UserTipo;

public record UsuarioFindAllDTO(Integer id, String nome, String cpf, String email, UserTipo tipo) {}
