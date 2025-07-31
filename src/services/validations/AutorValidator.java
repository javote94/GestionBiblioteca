package services.validations;

import dtos.LibroDTO;

public class AutorValidator implements ValidatorToSave, ValidatorToUpdate {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getAutor() == null || libroDTO.getAutor().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacío");
        }
    }
}
