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
//procedimiento para que nos devuelva la suma de dos enteros

public class ProcSum{
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab12G2", "root", "123456")) {
            CallableStatement stmt = con.prepareCall("{? = call sum4(?, ?)}");
            stmt.setInt(2, 10);
            stmt.setInt(3, 43);
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.execute();

            System.out.println("Resultado de la suma: " + stmt.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
