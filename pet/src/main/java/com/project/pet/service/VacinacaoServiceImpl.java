package com.project.pet.service;

import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Vacinacao;
import com.project.pet.repository.UsuarioRepository;
import com.project.pet.repository.VacinacaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VacinacaoServiceImpl implements VacinacaoService{
    @Autowired
    private VacinacaoRepository vacinacaoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Vacinacao saveVacinacao(Vacinacao vacinacao) {
        return vacinacaoRepository.save(vacinacao);
    }

    @Override
    public List<VacinacaoFindAllDTO> fetchVacinacaoList() {       
        return vacinacaoRepository.findAllVacinacoes();
    }
    
    @Override
    public List<VacinacaoFindAllDTO> fetchVacinacaoListByCPF(VacinacaoFindAllByCpfDTO cpf) {
        List<UsuarioFindAllDTO> usuarios = usuarioRepository.findBycpfStartingWith(cpf.cpf());
        
        if (usuarios == null) {
            throw new EntityNotFoundException("Vacinações do tutor com cpf " + cpf.cpf() + " não encontrado");
        }
        
        if (usuarios.isEmpty()) {
            return List.of();
        }
        
        List<VacinacaoFindAllDTO> vacinacoes = vacinacaoRepository.findAllVacinacoesByIdUsuario((long) usuarios.get(0).id());

        return vacinacoes;
    }

    @Override
    public Vacinacao updateVacinacao(Vacinacao vacinacao) {
        return vacinacaoRepository.save(vacinacao);
    }

    @Override
    public void deleteVacinacaoById(Long Id) {
        vacinacaoRepository.deleteById(Id);
    }
}
