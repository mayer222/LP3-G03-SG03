/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sql;

/**
 *
 * @author admin
 */
import java.sql.*;

public class Prepared_Statement {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab12", "root", "12456");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, "4");
            stmt.setString(2, "José");
            stmt.setInt(3, 36);
            stmt.setString(4, "C/ D");
            stmt.setString(5, "lima");
            stmt.setString(6, "Peru");
            stmt.setString(7, null);
            stmt.setString(8, null);

            int i = stmt.executeUpdate();
            System.out.println(i + " registro insertado");
            
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
