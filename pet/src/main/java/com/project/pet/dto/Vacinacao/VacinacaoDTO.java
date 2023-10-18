package com.project.pet.dto.Vacinacao;

import java.time.LocalDate; 

public record VacinacaoDTO(Integer idTutor, Integer idAnimal, String descricao, LocalDate dataVacinacao, String hora, String status  ) {

}