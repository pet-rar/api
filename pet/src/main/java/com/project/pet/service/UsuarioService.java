package com.project.pet.service;

import java.util.List;

import com.project.pet.dto.Usuario.UsuarioDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindByCPFDTO;
import com.project.pet.dto.Usuario.UsuarioRegisterDTO;
import com.project.pet.dto.Usuario.UsuarioUpdateDTO;
import com.project.pet.model.Usuario;
import java.util.Map;

public interface UsuarioService {
    Usuario saveUsuario(UsuarioRegisterDTO usuario);

    List<UsuarioFindAllDTO> fetchUsuarioList();
    
    Map<String, Object> fetchUsuarioListPaginated(Integer page);

    UsuarioDTO fetchUsuario(long id);

    Usuario updateUsuario(UsuarioUpdateDTO usuario);

    void deleteUsuarioById(Long Id);
	
    Map<String, Object> findCPF(UsuarioFindByCPFDTO dto);
}
