package com.project.pet.dto.Vacinacao;

import java.time.LocalDate; 
import com.project.pet.model.VacinacaoStatus; 

public record VacinacaoFindAllDTO(Integer id, String animal_nome, String descricao, LocalDate data_vacinacao, VacinacaoStatus status) {}
