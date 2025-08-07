package controllers;

import dtos.LibroDTO;
import entities.Libro;
import services.LibroService;
import java.util.List;

// @RestController
// @RequestMapping("/libros")
// @Tag(name = "Libros", description = "Operaciones relacionadas con libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    // @PostMapping
    // @Operation(summary = "Crear un nuevo libro")
    // @ApiResponse(responseCode = "201", description = "Libro creado correctamente")
    // @ApiResponse(responseCode = "400", description = "Error al crear el libro")
    public ApiResponse<LibroDTO> postLibro(
            // @RequestBody
            // @Parameter(description = "Datos del libro a crear")
            LibroDTO libroDto) {
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

    // @PutMapping
    // @Operation(summary = "Actualizar un libro existente")
    // @ApiResponse(responseCode = "200", description = "Libro actualizado correctamente")
    // @ApiResponse(responseCode = "400", description = "Error al actualizar el libro")
    public ApiResponse<Void> putLibro(
            // @RequestBody
            // @Parameter(description = "Datos del libro a actualizar")
            LibroDTO libroDto) {
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

    // @DeleteMapping("/{id}")
    // @Operation(summary = "Eliminar un libro por ID")
    // @ApiResponse(responseCode = "204", description = "Libro eliminado")
    // @ApiResponse(responseCode = "400", description = "ID inválido")
    public ApiResponse<Void> deleteLibro(
            // @PathVariable
            // @Parameter(description = "ID del libro a eliminar")
            Long id) {
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

    // @GetMapping("/{id}")
    // @Operation(summary = "Buscar un libro por ID")
    // @ApiResponse(responseCode = "200", description = "Libro encontrado")
    // @ApiResponse(responseCode = "400", description = "ID inválido")
    public ApiResponse<LibroDTO> getLibro(
            // @PathVariable
            // @Parameter(description = "ID del libro a consultar")
            Long id) {
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

    // @GetMapping
    // @Operation(summary = "Obtener todos los libros")
    // @ApiResponse(responseCode = "200", description = "Lista de libros")
    // @ApiResponse(responseCode = "404", description = "No se encontraron libros")
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
