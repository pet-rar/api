package com.project.pet.service;

import java.util.List;

import com.project.pet.model.Animal;

public interface AnimalService {
	
	// Save operation
	Animal saveAnimal(Animal animal);
 
    // Read operation
    List<Animal> fetchAnimalList();
 
    // Update operation
    Animal updateAnimal(Animal Animal);
 
    // Delete operation
    void deleteAnimalById(Long Id);


}
