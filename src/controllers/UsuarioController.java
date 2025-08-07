package controllers;

import dtos.UsuarioDTO;
import services.UsuarioService;

import java.util.List;

// @RestController
// @RequestMapping("/usuarios")
// @Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // @PostMapping
    // @Operation(summary = "Crear un nuevo usuario")
    // @ApiResponse(responseCode = "201", description = "Usuario creado correctamente")
    // @ApiResponse(responseCode = "400", description = "Error al crear el usuario")
    public ApiResponse<UsuarioDTO> postUsuario(
            // @RequestBody
            // @Parameter(description = "Datos del usuario a crear")
            UsuarioDTO usuarioDto) {
        ApiResponse<UsuarioDTO> response = new ApiResponse<>();
        try {
            UsuarioDTO usuarioDTO = service.save(usuarioDto);
            response.setStatusCode(201);
            response.setData(usuarioDTO);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    // @PutMapping
    // @Operation(summary = "Actualizar un usuario")
    // @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente")
    // @ApiResponse(responseCode = "400", description = "Error al actualizar el usuario")
    public ApiResponse<Void> putUsuario(
            // @RequestBody
            //  @Parameter(description = "Datos del usuario a actualizar")
            UsuarioDTO usuarioDto) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            service.update(usuarioDto);
            response.setStatusCode(200);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    // @DeleteMapping("/{id}")
    // @Operation(summary = "Eliminar un usuario por ID")
    // @ApiResponse(responseCode = "204", description = "Usuario eliminado")
    // @ApiResponse(responseCode = "400", description = "ID inválido")
    public ApiResponse<Void> deleteUsuario(
            // @PathVariable
            // @Parameter(description = "ID del usuario a eliminar")
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
    // @Operation(summary = "Buscar usuario por ID")
    // @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    // @ApiResponse(responseCode = "400", description = "ID inválido")
    public ApiResponse<UsuarioDTO> getUsuario(
            // @PathVariable
            // @Parameter(description = "ID del usuario a consultar")
            Long id) {
        ApiResponse<UsuarioDTO> response = new ApiResponse<>();
        try {
            UsuarioDTO usuarioDTO = service.findById(id);
            response.setStatusCode(200);
            response.setData(usuarioDTO);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    // @GetMapping
    // @Operation(summary = "Listar todos los usuarios")
    // @ApiResponse(responseCode = "200", description = "Lista de usuarios")
    // @ApiResponse(responseCode = "404", description = "No se encontraron usuarios")
    public ApiResponse<List<UsuarioDTO>> getAllUsuarios() {
        ApiResponse<List<UsuarioDTO>> response = new ApiResponse<>();
        try {
            List<UsuarioDTO> usuarios = service.findAll();
            response.setStatusCode(200);
            response.setData(usuarios);
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e);
        }
        return response;
    }
}
