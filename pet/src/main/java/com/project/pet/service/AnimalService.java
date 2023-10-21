package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import java.util.List;

import com.project.pet.model.Animal;

public interface AnimalService {
	
    // Save operation
    Animal saveAnimal(Animal animal);
 
    // Read operation
    List<AnimalFindAllDTO> fetchAnimalListByCPF(AnimalFindAllByCpfDTO cpf);
    
    // Read operation
    List<AnimalFindAllDTO> fetchAnimalList();
 
    // Update operation
    Animal updateAnimal(Animal Animal);
 
    // Delete operation
    void deleteAnimalById(Long Id);


}
