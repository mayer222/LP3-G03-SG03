package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DBPeticiones {
    private Conexion conn;
    DBPeticiones()throws SQLException,ClassNotFoundException{
        conn=new Conexion();
    }
    public void correrQuery(String query,JTable table)throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement estamento=conn.getConn().prepareStatement(query);
        estamento.executeUpdate();
        executeFilter("SELECT * FROM user",table);
        estamento.close();
    }
    public void executeFilter(String query,JTable table)throws SQLException{
        Statement estamento=conn.getConn().createStatement();
        ResultSet result=estamento.executeQuery(query);
        ResultSetMetaData metaData= (ResultSetMetaData) result.getMetaData();
        int columns=metaData.getColumnCount();
         List<String[]> data = new ArrayList<>();
        while (result.next()) {
            String[] row=new String[columns];
            for (int i = 0; i < columns; i++) {
                row[i]=result.getString(i+1);
            }
            data.add(row);
        } 
        String[][] dataArray = data.toArray(new String[0][0]);
        table.setModel(new DefaultTableModel(dataArray,new String[]{"AUTHORID","FIRSTNAME","LASTNAME"}));
        estamento.close();
    }

}
