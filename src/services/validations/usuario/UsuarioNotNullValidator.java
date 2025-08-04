package services.validations.usuario;

import dtos.UsuarioDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class UsuarioNotNullValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {
    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
    }
}
