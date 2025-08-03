package dao.impl;

import dao.ConnectionFactory;
import dao.IDao;
import entities.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class LibroDaoMySql implements IDao<Libro> {

    private static final String SQL_INSERT = "INSERT INTO libros(titulo, autor, anio_publicacion, disponible, usuario_id) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE libros SET titulo = ?, autor = ?, anio_publicacion = ?, disponible = ?, usuario_id = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM libros WHERE id = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM libros WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM libros ORDER BY id";

    @Override
    public void save(Libro libro) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getAnioPublicacion());
            statement.setBoolean(4, libro.isDisponible());
            if (libro.getUsuarioId() != null) {
                statement.setLong(5, libro.getUsuarioId());
            } else {
                statement.setNull(5, Types.BIGINT);
            }
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    libro.setId(keys.getLong(1));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el libro en la base de datos", e);
        }
    }

    @Override
    public void update(Libro libro) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_UPDATE)) {

            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getAnioPublicacion());
            statement.setBoolean(4, libro.isDisponible());

            if (libro.getUsuarioId() != null) {
                statement.setLong(5, libro.getUsuarioId());
            } else {
                statement.setNull(5, Types.BIGINT);
            }

            statement.setLong(6, libro.getId());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el libro", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_DELETE)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el libro", e);
        }
    }

    @Override
    public Optional<Libro> findById(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_FIND_BY_ID)) {

            statement.setLong(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    Libro libro = mapResultSetToLibro(result);
                    return Optional.of(libro);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el libro por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Libro> findAll() {
        List<Libro> libros = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_SELECT_ALL);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                Libro libro = mapResultSetToLibro(result);
                libros.add(libro);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al recuperar todos los libros", e);
        }
        return libros;
    }

    private Libro mapResultSetToLibro(ResultSet result) throws SQLException {
        Libro libro = new Libro();
        libro.setId(result.getLong("id"));
        libro.setTitulo(result.getString("titulo"));
        libro.setAutor(result.getString("autor"));
        libro.setAnioPublicacion(result.getInt("anio_publicacion"));
        libro.setDisponible(result.getBoolean("disponible"));

        Long usuarioId = result.getLong("usuario_id");
        if (result.wasNull()) {
            libro.setUsuarioId(null);
        } else {
            libro.setUsuarioId(usuarioId);
        }
        return libro;
    }
}

