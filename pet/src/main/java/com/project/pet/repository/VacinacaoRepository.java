package com.project.pet.repository;

import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
    @Query("SELECT new com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO(v.id, a.nome, v.descricao, v.data_vacinacao, v.status) FROM Vacinacao v JOIN v.animal a")
    List<VacinacaoFindAllDTO> findAllVacinacoes();
}
