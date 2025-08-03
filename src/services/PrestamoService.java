package services;

public interface PrestamoService {
    void prestarLibro(Long libroId, Long usuarioId);
    void devolverLibro(Long libroId);
}
