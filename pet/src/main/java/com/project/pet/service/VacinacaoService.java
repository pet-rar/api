package com.project.pet.service;

import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import java.util.List;

import com.project.pet.model.Vacinacao;

public interface VacinacaoService {
    Vacinacao saveVacinacao(Vacinacao vacinacao);

    List<VacinacaoFindAllDTO> fetchVacinacaoList();
    
    List<VacinacaoFindAllDTO> fetchVacinacaoListByCPF(VacinacaoFindAllByCpfDTO cpf);

    Vacinacao updateVacinacao(Vacinacao vacinacao);

    void deleteVacinacaoById(Long Id);
}
