package com.project.pet.controller;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.model.Animal;
import com.project.pet.service.AnimalService;

@RestController
public class AnimalController {
    @Autowired
    private AnimalService AnimalService;

    @PostMapping("/animal")
    public Animal saveAnimal(@Valid @RequestBody Animal Animal) {
        return AnimalService.saveAnimal(Animal);
    }

    @GetMapping("/animal")
    public List<AnimalFindAllDTO> listAnimal() {
           return AnimalService.fetchAnimalList();
    }
    
    @GetMapping("/animal/{id}")
    public AnimalDTO findAnimal(@PathVariable("id") Long id) {
           return AnimalService.fetchAnimal(id);
    }

    @PostMapping("/animal/cpf")
    public List<AnimalFindAllDTO> listAnimalByCPF(@Valid @RequestBody AnimalFindAllByCpfDTO cpf) {
        return AnimalService.fetchAnimalListByCPF(cpf);
    }

    @PostMapping("/animalUpdate")
    public Animal updateAnimal(Animal Animal) {
        return AnimalService.updateAnimal(Animal);
    }

    @DeleteMapping("/animal/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long Id) {
        AnimalService.deleteAnimalById(Id);
        return "Deleted Successfully";
    }
}
