package dao;

import java.sql.Connection;
import java.sql.Statement;

public class DBHelper {

    private static final String SQL_CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS libros (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(100) NOT NULL,
                autor VARCHAR(100) NOT NULL,
                anio_publicacion INT NOT NULL,
                disponible BOOLEAN NOT NULL
            );
        """;
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS libros;";

    public static void createTableIfNotExists() {

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(SQL_DROP_TABLE);
            stmt.execute(SQL_CREATE_TABLE);
            System.out.println("Tabla 'libros' verificada o creada exitosamente.");

        } catch (Exception e) {
            throw new RuntimeException("Error al crear la tabla 'libros'", e);
        }
    }

}
