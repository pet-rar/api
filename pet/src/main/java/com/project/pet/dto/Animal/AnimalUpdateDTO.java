package com.project.pet.dto.Animal;

import java.time.LocalDate;

public record AnimalUpdateDTO(Integer idAnimal, LocalDate nadaNascimento, String especie, String raca, String tipo, String porte, String pelagem, String cor, Double peso, Integer idTutor ) {

}
