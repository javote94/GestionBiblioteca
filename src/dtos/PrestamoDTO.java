package dtos;

// @Schema(description = "DTO que representa un préstamo de libro a un usuario")
public class PrestamoDTO {

    // @Schema(description = "ID del libro prestado")
    private Long libroId;
    // @Schema(description = "ID del usuario que recibe el préstamo")
    private Long usuarioId;

    public PrestamoDTO() {
    }

    public PrestamoDTO(Long libroId, Long usuarioId) {
        this.libroId = libroId;
        this.usuarioId = usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

}
