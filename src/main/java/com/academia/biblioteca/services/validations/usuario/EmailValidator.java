package com.academia.biblioteca.services.validations.usuario;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class EmailValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {

    @Override
    public void validate(UsuarioDTO dto) {
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!dto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("El email no es válido");
        }
    }
}
