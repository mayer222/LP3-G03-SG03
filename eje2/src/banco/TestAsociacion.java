
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class TestAsociacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Mi Banco");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Mostrar Clientes por Tipo");
            System.out.println("5. Mostrar Todos los Clientes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el tipo de cliente (C/B/E): ");
                    String tipoCliente = scanner.nextLine();
                    Persona nuevoCliente = new Persona(nombreCliente, tipoCliente);
                    banco.agregarCliente(nuevoCliente);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del cliente a buscar: ");
                    nombreCliente = scanner.nextLine();
                    Persona clienteEncontrado = banco.buscarCliente(nombreCliente);
                    if (clienteEncontrado != null) {
                        System.out.println("Cliente encontrado: " + clienteEncontrado);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del cliente a eliminar: ");
                    nombreCliente = scanner.nextLine();
                    Persona clienteEliminado = banco.darBajaCliente(nombreCliente);
                    if (clienteEliminado != null) {
                        System.out.println("Cliente eliminado: " + clienteEliminado);
                    } else {
                        System.out.println("Cliente no encontrado o no eliminado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el tipo de cliente a mostrar (C/B/E): ");
                    tipoCliente = scanner.nextLine();
                    banco.clienteTipo(tipoCliente);
                    break;

                case 5:
                    System.out.println(banco);
                    break;

                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }
        }
    }
}