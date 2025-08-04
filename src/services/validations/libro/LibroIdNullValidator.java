package services.validations.libro;

import dtos.LibroDTO;
import services.validations.ValidatorToSave;

public class LibroIdNullValidator implements ValidatorToSave<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getId() != null) {
            throw new IllegalArgumentException("El ID del libro debe ser nulo. La base de datos asignará un ID automáticamente");
        }
    }
}
