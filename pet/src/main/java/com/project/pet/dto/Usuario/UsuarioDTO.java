package com.project.pet.dto.Usuario;

import java.util.Date;

import com.project.pet.model.UserTipo;

public record UsuarioDTO(String nome, String cpf, Date dataNascimento, String telefone, UserTipo tipo, String email, String senha) {
}