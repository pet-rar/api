package com.project.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.project.pet.dto.Usuario.UsuarioDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByemail(String email);

    Page<UsuarioFindAllDTO> findBycpfStartingWith(String cpf, Pageable pageable);
		
    @Query("SELECT new com.project.pet.dto.Usuario.UsuarioFindAllDTO(u.id, u.nome, u.cpf, u.email, u.tipo) FROM Usuario u")
    List<UsuarioFindAllDTO> findAllUsuarios();
    
    @Query("SELECT new com.project.pet.dto.Usuario.UsuarioFindAllDTO(u.id, u.nome, u.cpf, u.email, u.tipo) FROM Usuario u")
    Page<UsuarioFindAllDTO> findPaginatedUsuarios(Pageable pageable);

    @Query("SELECT new com.project.pet.dto.Usuario.UsuarioDTO(u.id, u.nome, u.cpf, u.data_nascimento, u.telefone, u.tipo, u.email, e.id, e.logradouro, e.bairro, e.cidade, e.estado, e.cep) FROM Usuario u LEFT JOIN u.endereco e WHERE u.id = :id")
    UsuarioDTO findUsuario(@Param("id") long id);

}
