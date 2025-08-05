package com.academia.biblioteca.services.validations.libro;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class LibroNotNullValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
    }
}
