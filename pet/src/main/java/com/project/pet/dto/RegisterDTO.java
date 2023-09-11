package com.project.pet.dto;

import com.project.pet.model.UserTipo;

public record RegisterDTO(String nome, String senha, UserTipo tipo) {
}