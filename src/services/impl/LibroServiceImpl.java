package services.impl;

import dao.IDao;
import dtos.LibroDTO;
import entities.Libro;
import services.LibroService;
import services.mappers.LibroMapper;
import services.validations.LibroValidatorExecutor;
import java.util.List;
import java.util.Optional;

public class LibroServiceImpl implements LibroService {

    private final IDao<Libro> dao;

    public LibroServiceImpl(IDao<Libro> dao) {
        this.dao = dao;
    }

    @Override
    public void save(LibroDTO libroDTO) {
        LibroValidatorExecutor.validateToSave(libroDTO);
        Libro libro = LibroMapper.toEntity(libroDTO);
        dao.save(libro);
    }

    @Override
    public void update(LibroDTO libroDTO) {
        validateId(libroDTO.getId());
        LibroValidatorExecutor.validateToUpdate(libroDTO);
        Libro libroExistente = getLibroById(libroDTO.getId());
        libroExistente.setTitulo(libroDTO.getTitulo());
        libroExistente.setAutor(libroDTO.getAutor());
        libroExistente.setAnioPublicacion(libroDTO.getAnioPublicacion());
        libroExistente.setDisponible(libroDTO.isDisponible());
        dao.update(libroExistente);
    }

    @Override
    public void delete(Long id) {
        validateId(id);
        getLibroById(id);
        dao.delete(id);
    }

    @Override
    public LibroDTO findById(Long id) {
        validateId(id);
        Libro libro = getLibroById(id);
        return LibroMapper.toDTO(libro);
    }

    @Override
    public List<LibroDTO> findAll() {
        List<Libro> libros = dao.findAll();
        if (libros.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron libros en la base de datos");
        }
        return libros.stream()
                .map(LibroMapper::toDTO)
                .toList();
    }

    private void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del libro debe ser un número positivo");
        }
    }

    private Libro getLibroById(Long id) {
        Optional<Libro> libroOptional = dao.findById(id);
        if (libroOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró un libro con el ID proporcionado");
        }
        return libroOptional.get();
    }
}

