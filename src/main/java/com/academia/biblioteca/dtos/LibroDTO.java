package com.academia.biblioteca.dtos;

public class LibroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    private UsuarioDTO usuarioDTO;

    public LibroDTO(Long id, String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public LibroDTO(Long id, String titulo, String autor, int anioPublicacion, boolean disponible, UsuarioDTO usuarioDTO) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
        this.usuarioDTO = usuarioDTO;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Título: " + titulo +
               " | Autor: " + autor +
               " | Año: " + anioPublicacion +
               " | Disponible: " + disponible +
               " | Usuario: " + usuarioDTO;
    }

}
