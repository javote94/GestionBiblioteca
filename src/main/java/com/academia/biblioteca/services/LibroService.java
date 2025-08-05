package com.academia.biblioteca.services;

import com.academia.biblioteca.dtos.LibroDTO;

import java.util.List;

public interface LibroService {

    LibroDTO save(LibroDTO libroDTO);
    void update(LibroDTO libroDTO);
    void delete(Long id);
    LibroDTO findById(Long id);
    List<LibroDTO> findAll();
}
