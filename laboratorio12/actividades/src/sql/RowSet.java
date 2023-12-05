/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

/**
 *
 * @author admin
 */
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSet {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Creación y ejecución del RowSet
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/lab12");
            rowSet.setUsername("root");
            rowSet.setPassword("123456");
            rowSet.setCommand("SELECT * FROM clientes");
            rowSet.execute();

            System.out.println("\nInformacion de clientes:\n");

            while (rowSet.next()) {
                // Generando evento de movimiento del cursor
                System.out.println("ID: " + rowSet.getString(1));
                System.out.println("Nombre: " + rowSet.getString(2));
                System.out.println("Edad: " + rowSet.getInt(3));
                System.out.println("Dirección: " + rowSet.getString(4));
                System.out.println("Ciudad: " + rowSet.getString(5));
                System.out.println("Pais: " + rowSet.getString(6));
                System.out.println("Email: " + rowSet.getString(7));
                System.out.println("Telefono: " + rowSet.getString(8) + "\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
