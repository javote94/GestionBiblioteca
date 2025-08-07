package controllers;

import dtos.PrestamoDTO;
import services.PrestamoService;

// @RestController
// @RequestMapping("/prestamos")
// @Tag(name = "Préstamos", description = "Operaciones relacionadas con préstamos de libros")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    // @PostMapping
    // @Operation(summary = "Registrar un préstamo de libro")
    // @ApiResponse(responseCode = "200", description = "Préstamo realizado correctamente")
    // @ApiResponse(responseCode = "400", description = "Error al registrar el préstamo")
    public ApiResponse<Void> postPrestamo(
            // @RequestBody
            //@Parameter(description = "Datos del préstamo")
            PrestamoDTO prestamoDTO) {
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

    // @PutMapping("/devolver/{libroId}")
    // @Operation(summary = "Devolver un libro prestado")
    // @ApiResponse(responseCode = "200", description = "Libro devuelto correctamente")
    // @ApiResponse(responseCode = "400", description = "ID inválido o error de devolución")
    public ApiResponse<Void> devolver(
            // @PathVariable
            // @Parameter(description = "ID del libro a devolver")
            Long libroId) {
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
