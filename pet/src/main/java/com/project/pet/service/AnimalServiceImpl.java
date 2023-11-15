package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Animal.AnimalSaveDTO;
import com.project.pet.dto.Animal.AnimalUpdateDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Animal;
import com.project.pet.model.Usuario;
import com.project.pet.repository.AnimalRepository;
import com.project.pet.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class AnimalServiceImpl implements AnimalService {	
    @Autowired
    private AnimalRepository animalRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override public Animal saveAnimal(AnimalSaveDTO animal) {    
    	Long tutorId = Long.valueOf(animal.tutor_id());
    	
    	Optional<Usuario> usuarioOptional = usuarioRepository.findById(tutorId);
    	Usuario usuario = new Usuario();

    	if (usuarioOptional.isPresent()) {
    	    usuario = usuarioOptional.get();
    	} else {
            System.err.println("Erro: Usuário não cadastrado");
    	}
      
        Animal animalEntity = new Animal(animal.nome(), animal.data_nascimento(), animal.especie(), animal.raca(), animal.tipo(), animal.porte(), animal.cor(), animal.peso(), usuario);
    	    	 
        return animalRepository.save(animalEntity);
    }
    
    @Override
    public Map<String, Object> fetchAnimalListPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<AnimalFindAllDTO> animaisPage = animalRepository.findPaginatedAnimais(pageable);

        List<AnimalFindAllDTO> content = animaisPage.getContent();
        int totalPages = animaisPage.getTotalPages();

        Map<String, Object> result = new HashMap<>();
        result.put("content", content);        
        result.put("totalPages", totalPages);

        return result;
    }

    @Override
    public List<AnimalFindAllDTO> fetchAnimalList() {
        return animalRepository.findAllAnimais();
    }
    
    @Override
    public AnimalDTO fetchAnimal(long id) {	
        AnimalDTO animal = animalRepository.findAnimal(id);

        if(animal == null) {
            throw new EntityNotFoundException("Animal não encontrado");
        }

       return animal;
    }

    @Override
    public Animal updateAnimal(AnimalUpdateDTO animal) {    
        Long tutorId = Long.valueOf(animal.tutor_id());
    	
    	Optional<Usuario> usuarioOptional = usuarioRepository.findById(tutorId);
    	Usuario usuario = new Usuario();

    	if (usuarioOptional.isPresent()) {
    	    usuario = usuarioOptional.get();
    	} else {
            System.err.println("Erro: Usuário não cadastrado");
    	}
      
        Animal animalEntity = new Animal(animal.id(), animal.nome(), animal.data_nascimento(),animal.especie(),animal.raca(),animal.tipo(),animal.porte(), animal.cor(),animal.peso(), usuario);
    	    	
        return animalRepository.save(animalEntity);
    }

    @Override
    public void deleteAnimalById(Long Id) {
        animalRepository.deleteById(Id);
    }
        
    @Override
    public Map<String, Object> fetchAnimalListByCPF(AnimalFindAllByCpfDTO dto) {
        Pageable pageable = PageRequest.of(dto.page(), 5);
        Page<UsuarioFindAllDTO> usuariosPage = usuarioRepository.findBycpfStartingWith(dto.cpf(), pageable);
        
        if (usuariosPage.getContent() == null) {
            throw new EntityNotFoundException("Animais do tutor com cpf " + dto.cpf() + " não encontrado");
        }
        
        Map<String, Object> result = new HashMap<>();   
        List<UsuarioFindAllDTO> usuarios = usuariosPage.getContent();
                
        Page<AnimalFindAllDTO> animaisPage = animalRepository.findAllAnimaisByIdUsuario((long) usuarios.get(0).id(), pageable);        
        result.put("content", animaisPage.getContent());
        result.put("totalPages", animaisPage.getTotalPages());

        return result;
    }
}
