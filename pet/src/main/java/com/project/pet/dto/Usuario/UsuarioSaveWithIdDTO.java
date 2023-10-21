package com.project.pet.dto.Usuario;

import java.time.LocalDate;

import com.project.pet.model.UserTipo;

public record UsuarioSaveWithIdDTO(Integer id, String nome, String cpf, LocalDate data_nascimento, String telefone, UserTipo tipo, String email, String senha) {}
