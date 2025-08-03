package dtos;

public class LibroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
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
