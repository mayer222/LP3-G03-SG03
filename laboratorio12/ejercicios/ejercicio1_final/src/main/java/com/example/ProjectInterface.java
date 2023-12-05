package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectInterface extends JFrame {

    private JTextField queryField, filterField;
    private JPanel panel;
    private JButton queryButton, filterButton;
    private JTable table;
    private JLabel filtLabel;
    private JPanel superiorPanel, inferiorPanel;
    private DefaultTableModel tablaModel;
    private DBPeticiones peticiones;
    ProjectInterface() {
        try{
            peticiones=new DBPeticiones();
        }catch(Exception e){
            e.printStackTrace();
        }
        panel = new JPanel();
        queryField = new JTextField();
        queryField.setPreferredSize(new Dimension(400, 30));
        queryButton = new JButton("Mandar Query");
        table = new JTable();
        
        filtLabel = new JLabel("filtrado");
        filterField = new JTextField();
        filterField.setPreferredSize(new Dimension(400, 30));
        filterButton = new JButton("Mandar Filter");
        //aplicar columnas a la tabla
        tablaModel=new DefaultTableModel();
        tablaModel.addColumn("Nombre");
        tablaModel.addColumn("Apellido");
        table.setModel(tablaModel);
        //botones listeners
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try{
                    System.out.println(2);
                    peticiones.correrQuery(queryField.getText(),table);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try{
                    peticiones.executeFilter(filterField.getText(), table);
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });

        // parte superior de la interfaz
        superiorPanel = new JPanel();
        superiorPanel.add(queryField);
        superiorPanel.add(queryButton);

        // parte media de la interfaz
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // parte inferior de la interfaz
        inferiorPanel = new JPanel();
        inferiorPanel.add(filtLabel);
        inferiorPanel.add(filterField);
        inferiorPanel.add(filterButton);
    

        panel.setLayout(new BorderLayout());
        panel.add(superiorPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inferiorPanel, BorderLayout.SOUTH);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(()-> new ProjectInterface());
        } catch (Exception e) {
            System.out.println("Error al renderizar la interfaz");
        }
    }
}