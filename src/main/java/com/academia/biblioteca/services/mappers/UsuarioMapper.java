package com.academia.biblioteca.services.mappers;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.entities.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO dto) {
        return new Usuario(
                dto.getId(),
                dto.getNombre(),
                dto.getEmail(),
                dto.getDni(),
                dto.getEmail(),
                dto.getTelefono()
        );
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDni(),
                usuario.getEmail(),
                usuario.getTelefono()
        );
    }
}
