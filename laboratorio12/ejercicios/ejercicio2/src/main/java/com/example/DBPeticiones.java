package com.example;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DBPeticiones {
    private Conexion conn;

    DBPeticiones() throws SQLException, ClassNotFoundException {
        conn = new Conexion();
    }

    public int cambiarPantalla(int y) throws SQLException {
        Statement estamento = conn.getConn().createStatement();
        ResultSet cantObjects = estamento.executeQuery("SELECT COUNT (*) AS total FROM agenda");
        int total = cantObjects.next() ? cantObjects.getInt("total") : 0;
        ResultSet resultado;
        if (total >= y) {
            resultado = estamento.executeQuery("SELECT * FROM agenda WHERE id=" + y);
        }
        return y;
    }

    public void insetarAgenda(JTextField nombreF,JTextField apellidoF,JTextField direccionF,JTextField emailF,JTextField telefonoF,JLabel totalPage) throws SQLException {
        PreparedStatement estamentoPreparado = conn.getConn().prepareStatement("INSERT INTO agenda (nombre,apellido,email,telefono,direccion) values(?,?,?,?,?)");
        estamentoPreparado.setString(1,nombreF.getText());
        estamentoPreparado.setString(2,apellidoF.getText() );
        estamentoPreparado.setString(3,emailF.getText());
        estamentoPreparado.setString(4,telefonoF.getText());
        estamentoPreparado.setString(5,direccionF.getText());
        estamentoPreparado.executeUpdate();
        totalPage.setText(String.valueOf(Integer.parseInt(totalPage.getText())+1));
    }

    public void filterByLastName(String apellido,JLabel totalPage,JLabel thisPage) throws SQLException {
        PreparedStatement estamento = conn.getConn().prepareStatement("Select count (*) as total FROM agenda");

        ResultSet resultado = estamento.executeQuery();
        int total = resultado.next() ? resultado.getInt("total") : 0;
        totalPage.setText(String.valueOf(total));
        thisPage.setText(String.valueOf(1));


        String query="Select * from agenda where apellido Like ?";
        estamento=conn.getConn().prepareStatement(query);
        estamento.setString(1, "%"+apellido+"%");
        resultado=estamento.executeQuery();
        cambiarPantalla(Integer.parseInt(thisPage.getText()));
        estamento.close();
    }
    public void  createInputPanel(JPanel inputPanel,JLabel label,JTextField textoField){
        inputPanel.setLayout(new GridBagLayout());
        textoField.setPreferredSize(new Dimension(230,30));
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.anchor=GridBagConstraints.CENTER;
        gridBag.insets=new Insets(0,0,0,15);
        gridBag.gridx=0;
        inputPanel.add(label,gridBag);
        gridBag.gridx=1;
        inputPanel.add(textoField,gridBag);
    }

}
