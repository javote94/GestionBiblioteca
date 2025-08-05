package com.academia.biblioteca.services.validations.usuario;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class NombreApellidoValidator implements ValidatorToSave<UsuarioDTO>, ValidatorToUpdate<UsuarioDTO> {
    @Override
    public void validate(UsuarioDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (dto.getApellido() == null || dto.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
    }
}
