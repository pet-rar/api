package com.project.pet.service;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Animal;
import com.project.pet.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
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

}
