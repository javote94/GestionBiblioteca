package daos;

import entities.Libro;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibroDAO implements EntityDao<Libro> {
    private final Map<Long, Libro> data;
    private Long lastIdAdded = 0L;

    public LibroDAO() {
        this.data = new HashMap<>();
    }

    public Optional<Libro> findById(Long id) {
        if (!data.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(data.get(id));
    }

    public void Save(Libro newLibro) {
        if (newLibro.getId() != 0) {
            throw new IndexOutOfBoundsException("El libro ya posee un Id distinto de cero. Esto no está soportado.");
        }
        newLibro.setId(nextId());
        data.putIfAbsent(newLibro.getId(), newLibro);
    }

    private Long nextId() {
        return ++lastIdAdded;
    }
}
