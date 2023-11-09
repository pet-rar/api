package com.project.pet.dto.Animal;

import java.time.LocalDate;

import com.project.pet.model.AnimalPorte;
import com.project.pet.model.AnimalTipo;

public record AnimalDTO(Integer id, String nome, LocalDate data_nascimento, String especie, String raca, AnimalTipo tipo, AnimalPorte porte, String cor, Double peso, Integer tutor_id, String tutor_cpf) {}
