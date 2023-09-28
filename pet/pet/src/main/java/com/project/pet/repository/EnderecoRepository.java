package com.project.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {


}
