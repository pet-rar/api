package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import com.project.pet.dto.Vacinacao.VacinacaoUpdateDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Vacinacao;
import com.project.pet.model.Animal;
import com.project.pet.repository.AnimalRepository;
import com.project.pet.repository.UsuarioRepository;
import com.project.pet.repository.VacinacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    public Map<String, Object> fetchVacinacaoListPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<VacinacaoFindAllDTO> vacinacoesPage = vacinacaoRepository.findPaginatedVacinacoes(pageable);

        List<VacinacaoFindAllDTO> content = vacinacoesPage.getContent();
        int totalPages = vacinacoesPage.getTotalPages();

        Map<String, Object> result = new HashMap<>();
        result.put("content", content);        
        result.put("totalPages", totalPages);

        return result;
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
    public Map<String, Object> fetchVacinacaoListByCPF(VacinacaoFindAllByCpfDTO dto) {
        Pageable pageable = PageRequest.of(dto.page(), 5);        
        Page<UsuarioFindAllDTO> usuariosPage = usuarioRepository.findBycpfStartingWith(dto.cpf(), pageable);
        
        if (usuariosPage.getContent() == null) {
            throw new EntityNotFoundException("Vacinações do tutor com cpf " + dto.cpf() + " não encontrado");
        }
        
        Map<String, Object> result = new HashMap<>();
        List<UsuarioFindAllDTO> usuarios = usuariosPage.getContent();        
        
        if (usuarios == null) {
            result.put("content", List.of());
            result.put("totalPages", 0);
            
            return result;
        }
                
        Page<VacinacaoFindAllDTO> vacinacoesPage = vacinacaoRepository.findAllVacinacoesByIdUsuario((long) usuarios.get(0).id(), pageable);        
                
        result.put("content", vacinacoesPage.getContent());
        result.put("totalPages", vacinacoesPage.getTotalPages());
        
        return result;
    }

    @Override
    public Vacinacao updateVacinacao(VacinacaoUpdateDTO vacinacao) {
        AnimalDTO animal = animalRepository.findAnimal((long) vacinacao.id_animal());
        
        Animal animalEntity = new Animal(animal);
        
        Vacinacao vacinacaoEntity = new Vacinacao(vacinacao, animalEntity);
        
        return vacinacaoRepository.save(vacinacaoEntity);
    }

    @Override
    public void deleteVacinacaoById(Long Id) {
        vacinacaoRepository.deleteById(Id);
    }
}
