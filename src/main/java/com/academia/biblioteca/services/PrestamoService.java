package com.academia.biblioteca.services;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.dtos.PrestamoDTO;

public interface PrestamoService {
    void prestarLibro(PrestamoDTO prestamoDTO);
    void devolverLibro(LibroDTO libroDTO);
}
