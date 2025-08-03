package controllers;

import services.PrestamoService;

public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    public ApiResponse<Void> postPrestamo(Long libroId, Long usuarioId) {
        ApiResponse<Void> res = new ApiResponse<>();
        try {
            prestamoService.prestarLibro(libroId, usuarioId);
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
