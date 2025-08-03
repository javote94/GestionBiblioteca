package services.validations;

import dtos.UsuarioDTO;

public class EmailValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO>{

    @Override
    public void validate(UsuarioDTO dto) {
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
    }
}
