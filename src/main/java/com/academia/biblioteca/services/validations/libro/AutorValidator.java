package com.academia.biblioteca.services.validations.libro;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class AutorValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getAutor() == null || libroDTO.getAutor().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacío");
        }
    }
}
