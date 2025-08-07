package dtos;

// @Schema(description = "DTO que representa un usuario del sistema")
public class UsuarioDTO {

    // @Schema(description = "Identificador único del usuario")
    private Long id;
    // @Schema(description = "Nombre del usuario")
    private String nombre;
    // @Schema(description = "Apellido del usuario")
    private String apellido;
    // @Schema(description = "Número de DNI del usuario")
    private String dni;
    // @Schema(description = "Email del usuario")
    private String email;
    // @Schema(description = "Número de teléfono del usuario")
    private String telefono;

    public UsuarioDTO(Long id, String nombre, String apellido, String dni, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nombre: " + nombre +
               " | Apellido: " + apellido +
               " | DNI: " + dni +
               " | Email: " + email +
               " | Teléfono: " + telefono;
    }

}
