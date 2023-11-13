
package empleado1;

import java.util.Scanner;

public class Validacion {

    public static void validarnum(String num) throws IllegalArgumentException {

        // Verifica si la entrada tiene 9 dígitos y comienza con 9
        if (num.matches("9\\d{8}") && num!="") {
            return;
        } else {
            throw new IllegalArgumentException("ingrese un dato valido");
        }
    }
    public static void validarVacio(String nombre){
        if(nombre==""){
            throw new IllegalArgumentException("Entrada no válida. Por favor, ingresa un sueldo válido.");
        }
    }

    public static void validarSueldo(String sueldo) throws IllegalArgumentException {

        try {
            Double.parseDouble(sueldo);
            if (sueldo == "") {
                throw new IllegalArgumentException("Entrada no válida. Por favor, ingresa un sueldo válido.");

            }
            return;
            // Si la conversión es exitosa, sal del bucle
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada no válida. Por favor, ingresa un sueldo válido.");
        }

    }
}

