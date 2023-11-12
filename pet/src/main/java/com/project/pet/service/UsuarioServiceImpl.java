package com.project.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.pet.dto.Usuario.UsuarioDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindByCPFDTO;
import com.project.pet.dto.Usuario.UsuarioRegisterDTO;
import com.project.pet.dto.Usuario.UsuarioUpdateDTO;
import com.project.pet.model.Endereco;
import com.project.pet.model.Usuario;
import com.project.pet.repository.EnderecoRepository;
import com.project.pet.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	     
       UserDetails user = usuarioRepository.findByemail(usuarioEntity.getEmail());
        
        if ( user != null) {
        	throw new IllegalArgumentException("O EMAIL informado já está cadastrado!");
         
        }

        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(usuario.usuario().senha()));
        usuarioEntity.setEndereco(enderecoEntity);

        return usuarioRepository.save(usuarioEntity);
    }

    @Override
    public List<UsuarioFindAllDTO> fetchUsuarioList() {
        return usuarioRepository.findAllUsuarios();
    }
    
    @Override
    public Map<String, Object> fetchUsuarioListPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<UsuarioFindAllDTO> usuariosPage = usuarioRepository.findPaginatedUsuarios(pageable);

        List<UsuarioFindAllDTO> content = usuariosPage.getContent();
        int totalPages = usuariosPage.getTotalPages();

        Map<String, Object> result = new HashMap<>();
        result.put("content", content);        
        result.put("totalPages", totalPages);

        return result;
    }
	
    @Override
    public UsuarioDTO fetchUsuario(long id) {	
        UsuarioDTO usuario = usuarioRepository.findUsuario(id);

        if(usuario == null) {
            throw new EntityNotFoundException("Usuario with ID " + id + " not found");
        }

       return usuario;
    }

    @Override
    public Usuario updateUsuario(UsuarioUpdateDTO usuario) {
        var endereco = new Endereco(usuario.endereco());

        var enderecoEntity = enderecoRepository.save(endereco);

        Usuario usuarioEntity = new Usuario(usuario.usuario());
        usuarioEntity.setEndereco(enderecoEntity);

        if (usuario.usuario().senha() != null) {
            usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(usuario.usuario().senha()));
        } else {
            Usuario existingUsuario = usuarioRepository.findById((long) usuarioEntity.getId()).orElse(null);

            if (existingUsuario != null) {
                usuarioEntity.setSenha(existingUsuario.getSenha());
            }
        }

        return usuarioRepository.save(usuarioEntity);
    }

    @Override
    public void deleteUsuarioById(Long Id) {		
        usuarioRepository.deleteById(Id);		
    }


    @Override
    public List<UsuarioFindAllDTO> findCPF(UsuarioFindByCPFDTO cpf) {
        List<UsuarioFindAllDTO> usuarios = usuarioRepository.findBycpfStartingWith(cpf.cpf());
        
        if (usuarios == null) {
            throw new EntityNotFoundException("Usuario com cpf " + cpf.cpf() + " não encontrado");
        }

        return usuarios;
    }
}
