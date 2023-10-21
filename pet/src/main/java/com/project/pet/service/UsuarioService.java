package com.project.pet.service;

import java.util.List;

import com.project.pet.dto.Usuario.UsuarioDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindByCPFDTO;
import com.project.pet.dto.Usuario.UsuarioRegisterDTO;
import com.project.pet.dto.Usuario.UsuarioUpdateDTO;
import com.project.pet.model.Usuario;

public interface UsuarioService {
    Usuario saveUsuario(UsuarioRegisterDTO usuario);

    List<UsuarioFindAllDTO> fetchUsuarioList();

    UsuarioDTO fetchUsuario(long id);

    Usuario updateUsuario(UsuarioUpdateDTO usuario);

    void deleteUsuarioById(Long Id);
	
    List<UsuarioFindAllDTO> findCPF(UsuarioFindByCPFDTO cpf);
}
