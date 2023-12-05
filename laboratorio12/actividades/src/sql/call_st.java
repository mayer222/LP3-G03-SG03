/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

/**
 *
 * @author admin
 */
import java.sql.*;

public class call_st {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab12", "root", "123456")) {
            CallableStatement stmt = con.prepareCall("{call insertar(?,?,?,?,?,?,?,?)}");
            stmt.setString(1, "5");
            stmt.setString(2, "Maria");
            stmt.setInt(3, 26);
            stmt.setString(4, "C/ E");
            stmt.setString(5, "Madrid");
            stmt.setString(6, "España");
            stmt.setString(7, null);
            stmt.setString(8, null);
            stmt.execute(); 
            System.out.println("Éxito");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
