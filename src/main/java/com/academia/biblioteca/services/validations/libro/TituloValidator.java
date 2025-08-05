package com.academia.biblioteca.services.validations.libro;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.validations.ValidatorToSave;
import com.academia.biblioteca.services.validations.ValidatorToUpdate;

public class TituloValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getTitulo() == null || libroDTO.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
    }


}
