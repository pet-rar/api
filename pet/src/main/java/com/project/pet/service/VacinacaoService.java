package com.project.pet.service;

import com.project.pet.dto.Vacinacao.VacinacaoDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import com.project.pet.dto.Vacinacao.VacinacaoUpdateDTO;
import java.util.List;

import com.project.pet.model.Vacinacao;
import java.util.Map;

public interface VacinacaoService {
    Vacinacao saveVacinacao(VacinacaoSaveDTO vacinacao);    
    
    Map<String, Object> fetchVacinacaoListPaginated(Integer page);

    List<VacinacaoFindAllDTO> fetchVacinacaoList();
    
    Map<String, Object> fetchVacinacaoListByCPF(VacinacaoFindAllByCpfDTO dto);
    
    VacinacaoDTO fetchVacinacao(Long id);

    Vacinacao updateVacinacao(VacinacaoUpdateDTO vacinacao);

    void deleteVacinacaoById(Long Id);
}
