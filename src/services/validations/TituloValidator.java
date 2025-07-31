package services.validations;

import dtos.LibroDTO;

public class TituloValidator implements ValidatorToSave, ValidatorToUpdate {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getTitulo() == null || libroDTO.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
    }
}
