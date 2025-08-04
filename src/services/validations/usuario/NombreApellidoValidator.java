package services.validations.usuario;

import dtos.UsuarioDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class NombreApellidoValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {
    @Override
    public void validate(UsuarioDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (dto.getApellido() == null || dto.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
    }
}
