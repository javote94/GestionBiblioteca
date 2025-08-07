package dtos;

// @Schema(description = "DTO que representa un libro en el sistema")
public class LibroDTO {

    // @Schema(description = "Identificador único del libro")
    private Long id;
    // @Schema(description = "Título del libro")
    private String titulo;
    // @Schema(description = "Autor del libro")
    private String autor;
    // @Schema(description = "Año de publicación del libro")
    private int anioPublicacion;
    // @Schema(description = "Indica si el libro está disponible para préstamo")
    private boolean disponible;
    // @Schema(description = "Identificador del usuario que tiene el libro prestado")
    private Long usuarioId;

    public LibroDTO(Long id, String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public LibroDTO(Long id, String titulo, String autor, int anioPublicacion, boolean disponible, Long usuarioId) {
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Título: " + titulo +
               " | Autor: " + autor +
               " | Año: " + anioPublicacion +
               " | Disponible: " + disponible +
               " | Usuario: " + usuarioId;
    }

}
