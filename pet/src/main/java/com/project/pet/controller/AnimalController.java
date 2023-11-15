package com.project.pet.controller;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllByCpfDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Animal.AnimalSaveDTO;
import com.project.pet.dto.Animal.AnimalUpdateDTO;
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
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AnimalController {
    @Autowired
    private AnimalService AnimalService;

    @PostMapping("/animal/save")
    public Animal saveAnimal(@Valid @RequestBody AnimalSaveDTO Animal) {
        return AnimalService.saveAnimal(Animal);
    }

    @GetMapping("/animal")
    public Map<String, Object> listAnimal(@RequestParam("page") Integer page) {
           return AnimalService.fetchAnimalListPaginated(page);
    }
    
    @GetMapping("/animal/{id}")
    public AnimalDTO findAnimal(@PathVariable("id") Long id) {
           return AnimalService.fetchAnimal(id);
    }

    @PostMapping("/animal/cpf")
    public Map<String, Object> listAnimalByCPF(@Valid @RequestBody AnimalFindAllByCpfDTO dto) {
        return AnimalService.fetchAnimalListByCPF(dto);
    }

    @PostMapping("/animal/update")
    public Animal updateAnimal(@Valid @RequestBody AnimalUpdateDTO Animal) {
        return AnimalService.updateAnimal(Animal);
    }

    @DeleteMapping("/animal/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long Id) {
        AnimalService.deleteAnimalById(Id);
        return "Deleted Successfully";
    }
}
