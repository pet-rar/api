package com.project.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	UserDetails findByemail(String email);
	
	@Query(value = "SELECT new com.project.pet.dto.Usuario.UsuarioFindAllDTO(u.id, u.cpf, u.nome, u.email, u.tipo) FROM Usuario u")
	List<UsuarioFindAllDTO> findAllUsuarios();
	
	@Query(value = "SELECT eu.id_usuario,u.cpf,u.nome,u.email,u.tipo,e.bairro,e.cidade,"
			+ "e.estado,e.logradouro"
			+ " from usuario as u inner join enderecos as e"
			+ "on u.id_endereco=e.id_endereco)", nativeQuery = true)
	Usuario findById(long id);

}
