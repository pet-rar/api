package com.project.pet.dto.Vacinacao;

import java.time.LocalDateTime;


import com.project.pet.model.AnimalPorte;

public record CarterinhaDTO(String descricao, LocalDateTime data_vacinacao,Integer id, String nome, String especie, String raca,AnimalPorte porte, String tutor_nome) {
}