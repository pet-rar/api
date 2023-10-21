package com.project.pet.repository;

import com.project.pet.dto.Animal.AnimalDTO;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Animal;
import org.springframework.data.repository.query.Param;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {   
    @Query("SELECT new com.project.pet.dto.Animal.AnimalFindAllDTO(a.id, a.nome, a.especie, a.raca, a.usuario.nome) FROM Animal a")
    List<AnimalFindAllDTO> findAllAnimais();
    
    @Query("SELECT new com.project.pet.dto.Animal.AnimalDTO(a.id, a.nome, a.data_nascimento, a.especie, a.raca, a.tipo, a.porte, a.pelagem, a.cor, a.peso, u.id, u.cpf) FROM Animal a JOIN a.usuario u WHERE a.id = :id")
    AnimalDTO findAnimal(@Param("id") long id);
    
    @Query("SELECT new com.project.pet.dto.Animal.AnimalFindAllDTO(a.id, a.nome, a.especie, a.raca, a.usuario.nome) FROM Animal a WHERE a.usuario.id = :id")
    List<AnimalFindAllDTO> findAllAnimaisByIdUsuario(@Param("id") long id);
}
