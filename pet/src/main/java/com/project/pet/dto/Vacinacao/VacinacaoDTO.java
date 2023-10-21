package com.project.pet.dto.Vacinacao;

import java.time.LocalDateTime; 
import com.project.pet.model.VacinacaoStatus;

public record VacinacaoDTO(Integer id, String descricao, LocalDateTime data_vacinacao, VacinacaoStatus status, String tutor_cpf, Integer id_animal) {}
