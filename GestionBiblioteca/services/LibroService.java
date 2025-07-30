package services;

import dtos.LibroDTO;

public interface LibroService {

    void agregarLibro(LibroDTO libroDTO);
    LibroDTO obtenerLibroPorId(long id);
}
