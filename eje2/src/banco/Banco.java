/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;
import java.util.ArrayList;


class Banco {
    private String nombre;
    private ArrayList<Persona> clientes = new ArrayList<>();

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCliente(Persona cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("Cliente agregado con éxito.");
        } else {
            System.out.println("El cliente ya existe y no puede ser duplicado.");
        }
    }

    public Persona buscarCliente(String nombreCliente) {
        for (Persona cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public Persona darBajaCliente(String nombreCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().equalsIgnoreCase(nombreCliente)) {
                return clientes.remove(i);
            }
        }
        return null;
    }

    public void clienteTipo(String tipoCliente) {
        System.out.println("Clientes de tipo " + tipoCliente + ":");
        for (Persona cliente : clientes) {
            if (cliente.getTipo().equalsIgnoreCase(tipoCliente)) {
                System.out.println(cliente);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Clientes del banco " + nombre + ":\n");
        for (Persona cliente : clientes) {
            info.append(cliente).append("\n");
        }
        return info.toString();
    }
}