package com.project.pet.repository;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Animal;
import org.springframework.data.repository.query.Param;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {   
    @Query(value = "SELECT new com.project.pet.dto.Animal.AnimalFindAllDTO(a.id, a.nome, a.especie, a.raça, a.usuario.nome) FROM Animal a")
    List<AnimalFindAllDTO> findAllAnimais();
    
    @Query(value = "SELECT new com.project.pet.dto.Animal.AnimalFindAllDTO(a.id, a.nome, a.especie, a.raça, a.usuario.nome) FROM Animal a WHERE a.usuario.id = :id")
    List<AnimalFindAllDTO> findAllAnimaisByIdUsuario(@Param("id") long id);
}
