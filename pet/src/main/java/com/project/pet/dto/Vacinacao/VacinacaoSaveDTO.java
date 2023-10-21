package com.project.pet.dto.Vacinacao;

import java.time.LocalDateTime; 

public record VacinacaoSaveDTO(String descricao, LocalDateTime data_vacinacao, Integer id_animal) {}
