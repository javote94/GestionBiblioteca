package services.validations;

import dtos.LibroDTO;
import entities.Libro;

public class TituloValidator implements ValidatorToSave<LibroDTO>, ValidatorToUpdate<LibroDTO> {

    @Override
    public void validate(LibroDTO libroDTO) {
        if (libroDTO.getTitulo() == null || libroDTO.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
    }


}
