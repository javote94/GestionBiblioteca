package services.validations;

import dtos.UsuarioDTO;

public class NombreValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO>{
    @Override
    public void validate(UsuarioDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
}
