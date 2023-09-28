package com.project.pet.dto;

import com.project.pet.model.UserTipo;

public record RegisterDTO(String email, String senha, UserTipo tipo) {
}