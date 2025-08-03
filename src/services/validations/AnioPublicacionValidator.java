package services.validations;

import dtos.LibroDTO;

public class AnioPublicacionValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getAnioPublicacion() < 0) {
            throw new IllegalArgumentException("El año de publicación del libro debe ser un número positivo");
        }
    }
}
