package dtos;

public class PrestamoDTO {

    private Long libroId;
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
