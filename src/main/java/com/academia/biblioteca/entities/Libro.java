package com.academia.biblioteca.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    @Column(name = "anio_publicacion")
    private int anioPublicacion;

    private boolean disponible;

    @Column(name = "usuario_id")
    private Long usuarioId;


    public Libro() {}

    public Libro(String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public Libro(Long id, String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public Libro(Long id, String titulo, String autor, int anioPublicacion, boolean disponible, Long usuarioId) {
      this.id = id;
      this.titulo = titulo;
      this.autor = autor;
      this.anioPublicacion = anioPublicacion;
      this.disponible = disponible;
      this.usuarioId = usuarioId;
    }

    public Long getId() {
      return id;
  }

    public void setId(Long id) {
      this.id = id;
  }

    public String getTitulo() {
      return titulo;
  }

    public void setTitulo(String titulo) {
      this.titulo = titulo;
  }

    public String getAutor() {
      return autor;
  }

    public void setAutor(String autor) {
      this.autor = autor;
  }

    public int getAnioPublicacion() {
      return anioPublicacion;
  }

    public void setAnioPublicacion(int anioPublicacion) {
      this.anioPublicacion = anioPublicacion;
  }

    public boolean isDisponible() {
      return disponible;
  }

    public void setDisponible(boolean disponible) {
      this.disponible = disponible;
  }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Libro{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' +
               ", anioPublicacion=" + anioPublicacion +
               ", disponible=" + disponible +
               ", usuarioId=" + usuarioId +
               '}';
    }
}
