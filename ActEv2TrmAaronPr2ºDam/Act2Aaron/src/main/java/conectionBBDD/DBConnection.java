package conectionBBDD;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Objeto de conexión estático
    private static Connection connection;

    // Método para obtener la conexión
    public Connection getConnection() throws SQLException {
        // Si la conexión es nula o está cerrada, crea una nueva
        if (connection == null || connection.isClosed()) {
            createConnection();
        }
        return connection;
    }

    // Método privado para crear la conexión
    private void createConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/instituto";
        String user = "root";
        String password = "";
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexión a la base de datos establecida correctamente.");
    }
}
