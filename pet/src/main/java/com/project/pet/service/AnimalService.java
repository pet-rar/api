package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import java.util.List;

import com.project.pet.model.Animal;

public interface AnimalService {
    Animal saveAnimal(Animal animal);

    List<AnimalFindAllDTO> fetchAnimalListByCPF(AnimalFindAllByCpfDTO cpf);

    List<AnimalFindAllDTO> fetchAnimalList();
    
    AnimalDTO fetchAnimal(long id);

    Animal updateAnimal(Animal Animal);

    void deleteAnimalById(Long Id);
}
