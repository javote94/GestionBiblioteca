package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE = "db_biblioteca";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/" + DATABASE;
    private static final String USER = "admin01";
    private static final String PASSWORD = "admin01";

    static {
        try {
            Class.forName(DRIVER); // Se carga una sola vez al iniciar
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se pudo cargar el driver JDBC", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
}
