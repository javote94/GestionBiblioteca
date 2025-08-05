package com.academia.biblioteca.dao.jdbc.impl;

import com.academia.biblioteca.dao.jdbc.ConnectionFactory;
import com.academia.biblioteca.dao.IDao;
import com.academia.biblioteca.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDaoJdbcMySql implements IDao<Usuario> {

    private static final String SQL_INSERT = "INSERT INTO usuarios(nombre, apellido, dni, email, telefono) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, apellido = ?, dni = ?, email = ?, telefono = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM usuarios WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM usuarios ORDER BY id";


    @Override
    public Usuario save(Usuario usuario) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getDni());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTelefono());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) usuario.setId(keys.getLong(1));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el usuario", e);
        }
        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getDni());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTelefono());
            stmt.setLong(6, usuario.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el usuario", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario", e);
        }
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_ID)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefono(rs.getString("telefono"));
                    return Optional.of(usuario);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar usuario", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setDni(rs.getString("dni"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al listar usuarios", e);
        }
        return usuarios;
    }
}
