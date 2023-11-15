package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Animal.AnimalSaveDTO;
import com.project.pet.dto.Animal.AnimalUpdateDTO;
import java.util.List;

import com.project.pet.model.Animal;
import java.util.Map;

public interface AnimalService {
    Animal saveAnimal(AnimalSaveDTO animal);

    Map<String, Object> fetchAnimalListByCPF(AnimalFindAllByCpfDTO dto);
    
    Map<String, Object> fetchAnimalListPaginated(Integer page);

    List<AnimalFindAllDTO> fetchAnimalList();
    
    AnimalDTO fetchAnimal(long id);

    Animal updateAnimal(AnimalUpdateDTO Animal);

    void deleteAnimalById(Long Id);
}
