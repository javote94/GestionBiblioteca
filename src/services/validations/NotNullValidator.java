package services.validations;

import dtos.LibroDTO;

public class NotNullValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
    }
}
