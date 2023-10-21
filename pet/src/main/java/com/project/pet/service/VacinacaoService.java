package com.project.pet.service;

import java.util.List;

import com.project.pet.model.Vacinacao;

public interface VacinacaoService {
    Vacinacao saveVacinacao(Vacinacao vacinacao);

    List<Vacinacao> fetchVacinacaoList();

    Vacinacao updateVacinacao(Vacinacao vacinacao);

    void deleteVacinacaoById(Long Id);
}
