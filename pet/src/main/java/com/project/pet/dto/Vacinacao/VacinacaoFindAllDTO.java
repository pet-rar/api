package com.project.pet.dto.Vacinacao;

import java.time.LocalDateTime; 
import com.project.pet.model.VacinacaoStatus; 

public record VacinacaoFindAllDTO(Integer id, String animal_nome, String descricao, LocalDateTime data_vacinacao, VacinacaoStatus status) {}
