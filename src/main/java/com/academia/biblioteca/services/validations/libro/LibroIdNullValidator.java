package com.academia.biblioteca.services.validations.libro;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;

public class LibroIdNullValidator implements ValidatorToSave<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getId() != null) {
            throw new IllegalArgumentException("El ID del libro debe ser nulo. La base de datos asignará un ID automáticamente");
        }
    }
}
