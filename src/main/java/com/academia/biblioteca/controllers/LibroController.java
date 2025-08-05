package com.academia.biblioteca.controllers;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.LibroService;

import java.util.List;

public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    public ApiResponse<LibroDTO> postLibro(LibroDTO libroDto) {
        ApiResponse<LibroDTO> response = new ApiResponse<>();
        try {
            LibroDTO libroDTO = service.save(libroDto);
            response.setStatusCode(201);
            response.setData(libroDTO);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<Void> putLibro(LibroDTO libroDto) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            service.update(libroDto);
            response.setStatusCode(200);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<Void> deleteLibro(Long id) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            service.delete(id);
            response.setStatusCode(204); // No Content
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<LibroDTO> getLibro(Long id) {
        ApiResponse<LibroDTO> response = new ApiResponse<>();
        try {
            LibroDTO libroDTO = service.findById(id);
            response.setStatusCode(200);
            response.setData(libroDTO);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<List<LibroDTO>> getAllLibros() {
        ApiResponse<List<LibroDTO>> response = new ApiResponse<>();
        try {
            List<LibroDTO> libros = service.findAll();
            response.setStatusCode(200);
            response.setData(libros);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(404);
            response.setError(e);
        }
        return response;
    }

}
