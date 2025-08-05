package com.academia.biblioteca.services;

import com.academia.biblioteca.dtos.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    void update(UsuarioDTO usuarioDTO);
    void delete(Long id);
    UsuarioDTO findById(Long id);
    List<UsuarioDTO> findAll();
}
