package services;

import daos.EntityDao;
import dtos.LibroDTO;
import entities.Libro;
import java.util.Optional;

public class LibroServiceImpl implements LibroService {

    private final EntityDao<Libro> libroDAO;

    public LibroServiceImpl(EntityDao<Libro> libroDAO) {
        this.libroDAO = libroDAO;
    }

    @Override
    public void agregarLibro(LibroDTO libroDTO) {

        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (libroDTO.getTitulo() == null || libroDTO.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
        if (libroDTO.getAutor() == null || libroDTO.getAutor().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacío");
        }
        if (libroDTO.getAnioPublicacion() < 0) {
            throw new IllegalArgumentException("El año de publicación debe ser un número positivo");
        }

        Libro libro = new Libro(
                libroDTO.getId() != null ? libroDTO.getId() : 0L,
                libroDTO.getTitulo(),
                libroDTO.getAutor(),
                libroDTO.getAnioPublicacion(),
                true
        );


        libroDAO.Save(libro);
    }

    @Override
    public LibroDTO obtenerLibroPorId(long id) {

        Optional<Libro> libroOptional = libroDAO.findById(id);
        if (libroOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró un libro con el ID proporcionado");
        }
        Libro libro = libroOptional.get();

        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion()
        );
    }
}
