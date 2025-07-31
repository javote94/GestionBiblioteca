package dtos;

public class LibroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;

    public LibroDTO(Long id, String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
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
}
