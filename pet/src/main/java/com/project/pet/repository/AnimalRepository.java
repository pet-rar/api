package com.project.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {


}
