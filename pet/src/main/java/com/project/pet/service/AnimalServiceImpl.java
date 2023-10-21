package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Animal;
import com.project.pet.repository.AnimalRepository;
import com.project.pet.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalServiceImpl implements AnimalService {	
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public List<AnimalFindAllDTO> fetchAnimalList() {
        return animalRepository.findAllAnimais();
    }

    @Override
    public Animal updateAnimal(Animal Animal) {
        return animalRepository.save(Animal);
    }

    @Override
    public void deleteAnimalById(Long Id) {
        animalRepository.deleteById(Id);
    }
        
    @Override
    public List<AnimalFindAllDTO> fetchAnimalListByCPF(AnimalFindAllByCpfDTO cpf) {
        List<UsuarioFindAllDTO> usuarios = usuarioRepository.findBycpfStartingWith(cpf.cpf());        
        
        if (usuarios == null) {
            throw new EntityNotFoundException("Animais do tutor com cpf " + cpf.cpf() + " não encontrado");
        }
        
        if (usuarios.isEmpty()) {
            return List.of();
        }
        
        List<AnimalFindAllDTO> animais = animalRepository.findAllAnimaisByIdUsuario((long) usuarios.get(0).id());

        return animais;
    }

}
