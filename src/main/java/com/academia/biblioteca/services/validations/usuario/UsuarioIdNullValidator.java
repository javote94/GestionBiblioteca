package com.academia.biblioteca.services.validations.usuario;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;

public class UsuarioIdNullValidator implements ValidatorToSave<UsuarioDTO> {
    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId() != null) {
            throw new IllegalArgumentException("El ID del usuario debe ser nulo al crear un nuevo usuario.");
        }
    }
}
