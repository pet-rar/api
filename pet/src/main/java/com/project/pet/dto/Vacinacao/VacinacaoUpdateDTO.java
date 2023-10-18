package com.project.pet.dto.Vacinacao;

import java.time.LocalDate;

public record VacinacaoUpdateDTO(Integer idVacinacao, Integer idTutor, Integer idAnimal, String descricao, LocalDate dataVacinacao, String hora, String status) {

}
