
package empleado1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Empleado2 extends JFrame {
    private JTextField numField;
    private JTextField nombreField;
    private JTextField sueldoField;
    private DefaultTableModel tableModel;
    private Empleado1 Empleado1;

    public Empleado2() {
        //Aqui hscemos la configuración del JFrame
        Empleado1=new Empleado1("./data.txt");
        setTitle("Formulario de Empleados");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creamos los componentes
        numField = new JTextField(10);
        nombreField = new JTextField(18);
        sueldoField = new JTextField(10);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.setPreferredSize(new Dimension(100,30));

        // Configuración de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Número");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Sueldo");

        JTable table = new JTable(tableModel);

        setLayout(new GridLayout(0, 1, 5, 5)); // Varias filas, 1 columna, espaciado horizontal y vertical

        // Panel del número
        JPanel numPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        numPanel.add(new JLabel("Número:"));
        numPanel.add(numField);
        add(numPanel);

        // Panel del nombre
        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nombrePanel.add(new JLabel("Nombre:"));
        nombrePanel.add(nombreField);
        add(nombrePanel);

        // Panel del sueldo
        JPanel sueldoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sueldoPanel.add(new JLabel("Sueldo:"));
        sueldoPanel.add(sueldoField);
        add(sueldoPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(agregarButton);
        add(buttonPanel);
        add(new JScrollPane(table)); 
        agregarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                agregarEmpleado();
            }
        });
        try{
        Empleado1.reporteEmpleados(tableModel);
        }catch(Exception e){
            System.out.println("fallo");
        }
        setVisible(true);
    }

    private void agregarEmpleado(){
        String num = numField.getText();
        String nombre = nombreField.getText();
        String sueldo = sueldoField.getText();

        // Llamar al método agregarEmpleado de Empleado1
        try{
        Empleado1.agregarEmpleados(num, nombre, sueldo);
        Empleado1.reporteEmpleados(tableModel);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Empleado2::new);
    }
}
