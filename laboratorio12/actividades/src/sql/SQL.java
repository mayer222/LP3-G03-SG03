/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sql;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;

/**
 *
 * @author admin
 */
import java.sql.*;
public class SQL {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lab12", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
            
            System.out.println("Información de clientes:\n");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getString(1) +
                    ", Nombre: " + rs.getString(2) +
                    ", Edad: " + rs.getInt(3) +
                    ", Dirección: " + rs.getString(4) +
                    ", Ciudad: " + rs.getString(5) +
                    ", Estado: " + rs.getString(6) +
                    ", Código postal: " + rs.getString(7) +
                    ", Teléfono: " + rs.getString(8)
                );
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
