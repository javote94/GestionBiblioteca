package com.academia.biblioteca.services.validations.usuario;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class UsuarioNotNullValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {
    @Override
    public void validate(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
    }
}
