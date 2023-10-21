package com.project.pet.service;

import com.project.pet.dto.Vacinacao.VacinacaoDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import java.util.List;

import com.project.pet.model.Vacinacao;

public interface VacinacaoService {
    Vacinacao saveVacinacao(VacinacaoSaveDTO vacinacao);

    List<VacinacaoFindAllDTO> fetchVacinacaoList();
    
    List<VacinacaoFindAllDTO> fetchVacinacaoListByCPF(VacinacaoFindAllByCpfDTO cpf);
    
    VacinacaoDTO fetchVacinacao(Long id);

    Vacinacao updateVacinacao(Vacinacao vacinacao);

    void deleteVacinacaoById(Long Id);
}
