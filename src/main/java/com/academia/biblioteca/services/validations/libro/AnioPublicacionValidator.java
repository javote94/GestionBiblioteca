package com.academia.biblioteca.services.validations.libro;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class AnioPublicacionValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getAnioPublicacion() < 0) {
            throw new IllegalArgumentException("El año de publicación del libro debe ser un número positivo");
        }
    }
}
