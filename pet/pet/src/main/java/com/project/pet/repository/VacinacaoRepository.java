package com.project.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {

	@Query(value = "SELECT id,animal,descrição,datahora,status from vacinacao", nativeQuery = true)
	List<Vacinacao> findAll();
}
