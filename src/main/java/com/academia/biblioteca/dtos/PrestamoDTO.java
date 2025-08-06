package com.academia.biblioteca.dtos;

public class PrestamoDTO {

    private LibroDTO libroDTO;
    private UsuarioDTO usuarioDTO;

    public PrestamoDTO(LibroDTO libroDTO, UsuarioDTO usuarioDTO) {
        this.libroDTO = libroDTO;
        this.usuarioDTO = usuarioDTO;
    }

    public LibroDTO getLibroDTO() {
        return libroDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }
}
