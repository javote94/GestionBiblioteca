package services.mappers;

import dtos.LibroDTO;
import entities.Libro;

public class LibroMapper {

    public static Libro toEntity(LibroDTO dto) {
        return new Libro(
                dto.getId(),
                dto.getTitulo(),
                dto.getAutor(),
                dto.getAnioPublicacion(),
                dto.isDisponible()
        );
    }

    public static LibroDTO toDTO(Libro libro) {
        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion(),
                libro.isDisponible()
        );
    }
}
