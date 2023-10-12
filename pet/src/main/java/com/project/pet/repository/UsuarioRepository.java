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

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	UserDetails findByemail(String email);
	
	@Query(value = "SELECT new com.project.pet.dto.Usuario.UsuarioFindAllDTO(u.id, u.cpf, u.nome, u.email, u.tipo) FROM Usuario u")
	List<UsuarioFindAllDTO> findAllUsuarios();

	@Query("SELECT new com.project.pet.dto.Usuario.UsuarioDTO(u.id, u.nome, u.cpf, u.dataNascimento, u.telefone, u.tipo, u.email, e.id, e.logradouro, e.bairro, e.cidade, e.estado, e.cep) FROM Usuario u LEFT JOIN u.endereco e WHERE u.id = :id")
    UsuarioDTO findUsuario(@Param("id") long id);
}
