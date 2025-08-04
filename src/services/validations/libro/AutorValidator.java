package services.validations.libro;

import dtos.LibroDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class AutorValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getAutor() == null || libroDTO.getAutor().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacío");
        }
    }
}
