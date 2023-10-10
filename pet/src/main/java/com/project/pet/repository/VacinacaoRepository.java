package com.project.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {

	@Query(value = "SELECT v.id,a.nome,v.descricao,v.data_vacinacao,v.status  from vacinacao as v"
			+ "inner join animal as a on v.id_animal = a.id_animal", nativeQuery = true)
	List<Vacinacao> findAll();
}
