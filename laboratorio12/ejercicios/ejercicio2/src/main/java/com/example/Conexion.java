package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/itinerario";
    private static final String USER = "jason";
    private static final String PASSWORD = "123546";
    private static final String query="CREATE TABLE IF NOT EXISTS agenda (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(50) NOT NULL," +
                "apellido VARCHAR(50) NOT NULL,"+"email VARCHAR(50),"+"telefono VARCHAR(50),"+"direccion VARCHAR(50))";

    Conexion() throws SQLException, ClassNotFoundException {
        try {
            System.setProperty(DRIVER, "");
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Verifica si la tabla 'user' ya existe, y si no, la crea
            try (Statement statement = conn.createStatement()) {
                statement.execute(query);
            }
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar a la base de datos");
        }
    }
}