package com.project.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
	
	@Query(value = "SELECT id,nome,especie,raça,tutores from usuario", nativeQuery = true)
    List<Animal> findAll();
}
