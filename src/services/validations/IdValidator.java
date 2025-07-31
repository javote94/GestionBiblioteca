package services.validations;

import dtos.LibroDTO;

public class IdValidator implements ValidatorToSave {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getId() != null) {
            throw new IllegalArgumentException("El ID del libro debe ser nulo. La base de datos asignará un ID automáticamente");
        }
    }
}
