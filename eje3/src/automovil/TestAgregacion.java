/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automovil;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class TestAgregacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Automovil> automoviles = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Automovil");
            System.out.println("2. Eliminar Automovil");
            System.out.println("3. Mostrar Automoviles");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del automovil: ");
                    String placa = scanner.next();
                    System.out.print("Ingrese el num de puertas: ");
                    int numPuertas = scanner.nextInt();
                    System.out.print("Ingrese la marca del automovil: ");
                    String marca = scanner.next();
                    System.out.print("Ingrese el modelo del automovil: ");
                    String modelo = scanner.next();

                    System.out.print("Tiene motor? (S/N): ");
                    String tieneMotor = scanner.next();

                    Motor motor = null;

                    if (tieneMotor.equalsIgnoreCase("S")) {
                        System.out.print("Ingrese el num de motor: ");
                        String numMotor = scanner.next();
                        System.out.print("Ingrese las revoluciones por minuto del motor: ");
                        int revolucionesPorMinuto = scanner.nextInt();
                        motor = new Motor(numMotor, revolucionesPorMinuto);
                    }

                    Automovil automovil = new Automovil(placa, numPuertas, marca, modelo);
                    automovil.setMotor(motor);
                    automoviles.add(automovil);
                    System.out.println("Automovil agregado con exito.");
                    break;

                case 2:
                    if (!automoviles.isEmpty()) {
                        System.out.println("Lista de Automoviles:");
                        for (int i = 0; i < automoviles.size(); i++) {
                            System.out.println((i + 1) + ". " + automoviles.get(i));
                        }
                        System.out.print("Seleccione el num del automovil que desea eliminar: ");
                        int indiceEliminar = scanner.nextInt();
                        if (indiceEliminar >= 1 && indiceEliminar <= automoviles.size()) {
                            automoviles.remove(indiceEliminar - 1);
                            System.out.println("Automovil eliminado con exito.");
                        } else {
                            System.out.println("Opcion no valida.");
                        }
                    } else {
                        System.out.println("No hay automoviles para eliminar.");
                    }
                    break;

                case 3:
                    if (!automoviles.isEmpty()) {
                        System.out.println("Lista de Automoviles:");
                        for (int i = 0; i < automoviles.size(); i++) {
                            System.out.println((i + 1) + ". " + automoviles.get(i));
                        }
                    } else {
                        System.out.println("No hay automoviles para mostrar.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no válida. Por favor, seleccione una opcion valida.");
                    break;
            }
        }
    }
}