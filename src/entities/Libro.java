package entities;

public class Libro {
    
  private Long id;
  private String titulo;
  private String autor;
  private int anioPublicacion;
  private boolean disponible;

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

  @Override
  public String toString() {
      return "Libro{" +
              "id=" + id +
              ", titulo='" + titulo + '\'' +
              ", autor='" + autor + '\'' +
              ", anioPublicacion=" + anioPublicacion +
              ", disponible=" + disponible +
              '}';
  }

}
