package com.project.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
	
	@Query(value = "SELECT a.id_animal,a.nome,a.especie,a.raça,u.nome from animal as a inner join\r\n"
			+ "usuario as u on  a.id_usuario = u.id_usuario", nativeQuery = true)
    List<Animal> findAll();
}
