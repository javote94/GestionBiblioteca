package services.validations.usuario;

import dtos.UsuarioDTO;
import services.validations.ValidatorToSave;

public class UsuarioIdNullValidator implements ValidatorToSave<UsuarioDTO> {
    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId() != null) {
            throw new IllegalArgumentException("El ID del usuario debe ser nulo al crear un nuevo usuario.");
        }
    }
}
