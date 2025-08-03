package dao;

import java.sql.Connection;
import java.sql.Statement;

public class DBHelper {

    private static final String SQL_CREATE_TABLE_USUARIOS = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(50) NOT NULL,
                apellido VARCHAR(50) NOT NULL,
                dni VARCHAR(20) NOT NULL UNIQUE,
                email VARCHAR(100) NOT NULL UNIQUE,
                telefono VARCHAR(20)
            );
        """;
    private static final String SQL_CREATE_TABLE_LIBROS = """
            CREATE TABLE IF NOT EXISTS libros (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(100) NOT NULL,
                autor VARCHAR(100) NOT NULL,
                anio_publicacion INT NOT NULL,
                disponible BOOLEAN NOT NULL,
                usuario_id BIGINT,
                FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
            );
        """;
    private static final String SQL_DROP_TABLE_LIBROS = "DROP TABLE IF EXISTS libros;";
    private static final String SQL_DROP_TABLE_USUARIOS = "DROP TABLE IF EXISTS usuarios;";

    public static void createTables() {

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            // Eliminar primero la tabla dependiente
            stmt.execute(SQL_DROP_TABLE_LIBROS);
            stmt.execute(SQL_DROP_TABLE_USUARIOS);
            // Crear primero la tabla padre (usuarios)
            stmt.execute(SQL_CREATE_TABLE_USUARIOS);
            // Luego crear la tabla dependiente (libros)
            stmt.execute(SQL_CREATE_TABLE_LIBROS);

            System.out.println("Tablas 'usuarios' y 'libros' creadas/verificadas correctamente.");

        } catch (Exception e) {
            throw new RuntimeException("Error al crear las tablas de la base de datos", e);
        }
    }

}
