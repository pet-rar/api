package com.project.pet.dto.Animal;

import java.time.LocalDate;

public record AnimalDTO(Integer idTutor, String nome, LocalDate dataNascimento, String raca, String tipo, String porte, String pelagem, String cor, Double peso, String especie) {}
