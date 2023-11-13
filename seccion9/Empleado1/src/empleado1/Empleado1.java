
package empleado1;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class Empleado1 extends Archivo {
    Empleado1(String filepath) {
        super(filepath);
        try {
            super.createFile();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    void agregarEmpleados(String num, String nombre, String sueldo) throws Exception {
        String total = num + "," + nombre + "," + sueldo + "\n";
        Validacion.validarnum(num);
        Validacion.validarSueldo(sueldo);
        Validacion.validarVacio(nombre);
        super.writeToFile(total);
    }

    void reporteEmpleados(DefaultTableModel tableModel) throws IOException {
        String contenido = readFromFile();
        String[] lineas = contenido.split("\n");
        tableModel.setRowCount(0);// Limpiar la tabla antes de agregar nuevas filas

        for (String linea : lineas) {
            String[] campos = linea.split(",");
            tableModel.addRow(campos);

        }

    }

}

