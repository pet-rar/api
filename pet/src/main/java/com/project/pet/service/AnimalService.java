package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Animal.AnimalSaveDTO;
import com.project.pet.dto.Animal.AnimalUpdateDTO;
import java.util.List;

import com.project.pet.model.Animal;

public interface AnimalService {
    Animal saveAnimal(AnimalSaveDTO animal);

    List<AnimalFindAllDTO> fetchAnimalListByCPF(AnimalFindAllByCpfDTO cpf);

    List<AnimalFindAllDTO> fetchAnimalList();
    
    AnimalDTO fetchAnimal(long id);

    Animal updateAnimal(AnimalUpdateDTO Animal);

    void deleteAnimalById(Long Id);
}
