package com.example;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class App extends JFrame {

    private JTextField queryField, filterField, direccionField, nombreField, apellidoField, emailField, phoneField,
            findApellidoField;
    private JButton previusButton, nextButton, apellidoFindButton, searchAllButton, insertButton;
    private JTable table;
    private JLabel totalObjects, medium, thisPage, direccionLabel, nombreLabel, apellidoLabel, emailLabel, phoneLabel,
            findApellidoLabel;
    private JPanel panel, panelNav, direccionPanel, direccionInputPanel, nonbrePanel, nombreInputPanel, apellidoPanel,
            apellidoInputPanel, emailPanel, emailInputPanel, phonePanel, phoneInputPanel, findPanel, buttonPanel;
    private DefaultTableModel tablaModel;

    App() {
        // pantalla superior
        previusButton = new JButton("Previus");
        totalObjects = new JLabel("1");
        medium = new JLabel("of");
        thisPage = new JLabel("1");
        nextButton = new JButton("next");
        panelNav = new JPanel(new FlowLayout());
        // pantalla media
        // direccion
        direccionLabel = new JLabel("Direccion:");
        direccionField = new JTextField();
        direccionPanel = new JPanel(new GridLayout(1, 2));
        direccionInputPanel = new JPanel(new FlowLayout());
        // nombre
        nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        nonbrePanel = new JPanel(new GridLayout(1, 2));
        nombreInputPanel = new JPanel(new FlowLayout());
        // apellido
        apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField();
        apellidoPanel = new JPanel(new GridLayout(1, 2));
        apellidoInputPanel = new JPanel(new FlowLayout());
        // email
        emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailPanel = new JPanel(new GridLayout(1, 2));
        emailInputPanel = new JPanel(new FlowLayout());
        // phone
        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        phonePanel = new JPanel(new GridLayout(1, 2));
        phoneInputPanel = new JPanel(new FlowLayout());
        // find apellido
        findApellidoLabel = new JLabel("Apellido:");
        findApellidoField = new JTextField();
        apellidoFindButton = new JButton("Find");
        findPanel = new JPanel(new FlowLayout());
        // browse part
        searchAllButton = new JButton("Browse");
        insertButton = new JButton("Insert");
        buttonPanel = new JPanel(new FlowLayout());

        // tablaModel=new DefaultTableModel();
        // tablaModel.addColumn("Nombre");
        // tablaModel.addColumn("Apellido");
        // table.setModel(tablaModel);
        // pantalla media

        // parte superior de la interfaz
        panelNav.add(previusButton);
        panelNav.add(totalObjects);
        panelNav.add(medium);
        panelNav.add(thisPage);
        panelNav.add(nextButton);
        // parte media de la interfaz
        createInputPanel(direccionPanel,direccionLabel,direccionField);
        createInputPanel(nonbrePanel, nombreLabel, nombreField);
        createInputPanel(apellidoInputPanel, apellidoLabel, apellidoField);
        createInputPanel(emailInputPanel, emailLabel, emailField);
        createInputPanel(phoneInputPanel, phoneLabel, phoneField);

        findPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        findPanel.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Find entry by lastname"),
                        new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.GRAY)));
        findPanel.add(findApellidoLabel);
        findPanel.add(findApellidoField);
        findPanel.add(apellidoFindButton);
        findApellidoField.setPreferredSize(new Dimension(400, 30));
        buttonPanel.add(searchAllButton);
        buttonPanel.add(insertButton);
        // parte inferior de la interfaz
        panel = new JPanel(new GridLayout(8, 1));
        panel.add(panelNav);
        panel.add(direccionInputPanel);
        panel.add(nombreInputPanel);
        panel.add(apellidoInputPanel);
        panel.add(emailInputPanel);
        panel.add(phoneInputPanel);
        panel.add(findPanel);
        panel.add(buttonPanel);

        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> new App());
        } catch (Exception e) {
            System.out.println("Error al renderizar la interfaz");
        }
    }

    public void createInputPanel(JPanel inputPanel, JLabel label, JTextField textoField) {
        inputPanel.setLayout(new GridBagLayout());
        textoField.setPreferredSize(new Dimension(230, 30));
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.anchor = GridBagConstraints.CENTER;
        gridBag.insets = new Insets(0, 0, 0, 15);
        gridBag.gridx = 0;
        inputPanel.add(label, gridBag);
        gridBag.gridx = 1;
        inputPanel.add(textoField, gridBag);
    }
    
}
