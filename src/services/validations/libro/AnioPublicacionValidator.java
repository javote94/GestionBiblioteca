package services.validations.libro;

import dtos.LibroDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class AnioPublicacionValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getAnioPublicacion() < 0) {
            throw new IllegalArgumentException("El año de publicación del libro debe ser un número positivo");
        }
    }
}
