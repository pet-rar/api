package com.project.pet.service;

import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Vacinacao;
import com.project.pet.model.Animal;
import com.project.pet.repository.AnimalRepository;
import com.project.pet.repository.UsuarioRepository;
import com.project.pet.repository.VacinacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class VacinacaoServiceImpl implements VacinacaoService{
    @Autowired
    private VacinacaoRepository vacinacaoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AnimalRepository animalRepository;
    
    @Override
    public Vacinacao saveVacinacao(VacinacaoSaveDTO vacinacao) {
         Optional<Animal> animal = animalRepository.findById((long) vacinacao.id_animal());
        Animal animalEntity = new Animal(animal);

        Vacinacao vacinacaoEntity = new Vacinacao(vacinacao);
        vacinacaoEntity.setAnimal(animalEntity);
        
        return vacinacaoRepository.save(vacinacaoEntity);
    }

    @Override
    public List<VacinacaoFindAllDTO> fetchVacinacaoList() {       
        return vacinacaoRepository.findAllVacinacoes();
    }
    
    @Override
    public VacinacaoDTO fetchVacinacao(Long id) {	
        VacinacaoDTO vacinacao = vacinacaoRepository.findVacinacao(id);

        if(vacinacao == null) {
            throw new EntityNotFoundException("Vacinacao nao encontrada");
        }

       return vacinacao;
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
