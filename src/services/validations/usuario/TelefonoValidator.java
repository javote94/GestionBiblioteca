package services.validations.usuario;

import dtos.UsuarioDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class TelefonoValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {

    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getTelefono() == null || usuarioDTO.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
    }
}
