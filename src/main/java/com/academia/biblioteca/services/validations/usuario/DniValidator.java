package com.academia.biblioteca.services.validations.usuario;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

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
