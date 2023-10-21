package com.project.pet.dto.Vacinacao;

import java.time.LocalDateTime; 

public record VacinacaoDTO(Integer idTutor, Integer idAnimal, String descricao, LocalDateTime dataVacinacao, String hora, String status  ) {}
