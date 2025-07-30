package controllers;

import dtos.LibroDTO;
import entities.Libro;
import services.LibroService;

public class LibroController {
    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    public ApiResponse getLibro(long id) {
        ApiResponse response = new ApiResponse();
        try {
            LibroDTO result = service.obtenerLibroPorId(id);
            response.setStatusCode(200);
            response.setData(new LibroDTO[]{ result });
        }
        catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse postLibro(LibroDTO libroDto) {
        ApiResponse response = new ApiResponse();
        try {
            service.agregarLibro(libroDto);
            response.setStatusCode(201);
        }
        catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }
}
