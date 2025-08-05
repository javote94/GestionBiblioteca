package com.academia.biblioteca.controllers;

import com.academia.biblioteca.dtos.PrestamoDTO;
import com.academia.biblioteca.services.PrestamoService;

public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    public ApiResponse<Void> postPrestamo(PrestamoDTO prestamoDTO) {
        ApiResponse<Void> res = new ApiResponse<>();
        try {
            prestamoService.prestarLibro(prestamoDTO);
            res.setStatusCode(200);
        } catch (Exception e) {
            res.setStatusCode(400);
            res.setError(e);
        }
        return res;
    }

    public ApiResponse<Void> devolver(Long libroId) {
        ApiResponse<Void> res = new ApiResponse<>();
        try {
            prestamoService.devolverLibro(libroId);
            res.setStatusCode(200);
        } catch (Exception e) {
            res.setStatusCode(400);
            res.setError(e);
        }
        return res;
    }
}
