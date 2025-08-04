package services.validations.usuario;

import dtos.UsuarioDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class DniValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {

    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getDni() == null || usuarioDTO.getDni().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
        if (!usuarioDTO.getDni().matches("\\d+")) {
            throw new IllegalArgumentException("El DNI debe contener solo dígitos");
        }
    }
}
