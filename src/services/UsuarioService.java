package services;

import dtos.LibroDTO;
import dtos.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    void update(UsuarioDTO usuarioDTO);
    void delete(Long id);
    UsuarioDTO findById(Long id);
    List<UsuarioDTO> findAll();
}
