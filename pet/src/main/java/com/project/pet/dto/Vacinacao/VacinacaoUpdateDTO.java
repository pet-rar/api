package com.project.pet.dto.Vacinacao;

import java.time.LocalDateTime;
import com.project.pet.model.VacinacaoStatus;

public record VacinacaoUpdateDTO(Integer id, String descricao, LocalDateTime data_vacinacao, VacinacaoStatus status, Integer id_animal) {}

