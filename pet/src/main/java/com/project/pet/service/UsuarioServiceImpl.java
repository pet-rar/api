package com.project.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioRegisterDTO;
import com.project.pet.model.Endereco;
import com.project.pet.model.Usuario;
import com.project.pet.repository.EnderecoRepository;
import com.project.pet.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Usuario saveUsuario(UsuarioRegisterDTO usuario) {
		var endereco = Endereco.convertToEntity(usuario.endereco());
		
		var enderecoEntity = enderecoRepository.save(endereco);
		
		Usuario usuarioEntity = new Usuario(usuario.usuario());
		
		usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(usuario.usuario().senha()));
		usuarioEntity.setEndereco(enderecoEntity);
		
		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public List<UsuarioFindAllDTO> fetchUsuarioList() {		
		return usuarioRepository.findAllUsuarios();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuarioById(Long Id) {		
		usuarioRepository.deleteById(Id);		
	}

	@Override
	public Usuario findById(Long id) {
	    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
	    if (usuarioOptional.isPresent()) {
	        return usuarioOptional.get(); // Return the Usuario if it exists
	    } else {
	        throw new EntityNotFoundException("Usuario with ID " + id + " not found");
	    }
	}
}
