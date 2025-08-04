package services;

import dtos.PrestamoDTO;

public interface PrestamoService {
    void prestarLibro(PrestamoDTO prestamoDTO);
    void devolverLibro(Long libroId);
}
