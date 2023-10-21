package com.project.pet.repository;

import com.project.pet.dto.Vacinacao.VacinacaoDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pet.model.Vacinacao;
import org.springframework.data.repository.query.Param;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
    @Query("SELECT new com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO(v.id, a.nome, v.descricao, v.data_vacinacao, v.status) FROM Vacinacao v JOIN v.animal a")
    List<VacinacaoFindAllDTO> findAllVacinacoes();
    
    @Query("SELECT new com.project.pet.dto.Vacinacao.VacinacaoDTO(v.id, v.descricao, v.data_vacinacao, v.status, a.usuario.cpf, a.id) FROM Vacinacao v JOIN v.animal a WHERE v.id = :id")
    VacinacaoDTO findVacinacao(@Param("id") long id);
    
    @Query("SELECT new com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO(v.id, a.nome, v.descricao, v.data_vacinacao, v.status) FROM Vacinacao v JOIN v.animal a WHERE a.usuario.id = :id")
    List<VacinacaoFindAllDTO> findAllVacinacoesByIdUsuario(@Param("id") long id);
}
