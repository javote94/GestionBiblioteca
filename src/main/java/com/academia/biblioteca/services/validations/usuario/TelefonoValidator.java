package com.academia.biblioteca.services.validations.usuario;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class TelefonoValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {

    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getTelefono() == null || usuarioDTO.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
    }
}
