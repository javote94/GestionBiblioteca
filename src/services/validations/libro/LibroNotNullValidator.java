package services.validations.libro;

import dtos.LibroDTO;
import services.validations.ValidatorToSave;
import services.validations.ValidatorToUpdate;

public class LibroNotNullValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
    }
}
