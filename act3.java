import java.util.Scanner;

class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        // Determinar el número de cuenta (podrías generar un número único aquí)
        int numeroCuenta = 1; // Por ejemplo, asignamos un valor temporal
        this.cuenta = new Cuenta(numeroCuenta);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Cuenta: " + cuenta.toString();
    }

    public class Cuenta {
        private int numero;
        private double saldo;

        public Cuenta(int numero) {
            this(numero, 0);
        }

        public Cuenta(int numero, double saldo) {
            this.numero = numero;
            this.saldo = saldo;
        }

        public int getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        @Override
        public String toString() {
            return "Número de Cuenta: " + numero + ", Saldo: " + saldo;
        }
    }
}

class Banco {
    private String nombre;
    private Persona clientes[];
    private int numClientes;

    public Banco(String nombre) {
        this(nombre, 20);
    }

    public Banco(String nombre, int numClientes) {
        this.nombre = nombre;
        this.clientes = new Persona[numClientes];
        this.numClientes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona[] getClientes() {
        return clientes;
    }

    public void setClientes(Persona[] clientes) {
        this.clientes = clientes;
    }

    public int getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    public void agregarCliente(Persona persona) {
        if (numClientes < clientes.length) {
            boolean clienteExistente = false;
            for (int i = 0; i < numClientes; i++) {
                if (clientes[i].equals(persona)) {
                    clienteExistente = true;
                    break;
                }
            }
            if (!clienteExistente) {
                clientes[numClientes] = persona;
                numClientes++;
            } else {
                System.out.println("El cliente ya existe en el banco.");
            }
        } else {
            System.out.println("El banco ha alcanzado su capacidad máxima de clientes.");
        }
    }

    public boolean buscarCliente(Persona persona) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].equals(persona)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder infoClientes = new StringBuilder("Clientes del Banco " + nombre + ":\n");
        for (int i = 0; i < numClientes; i++) {
            infoClientes.append(clientes[i].toString()).append("\n");
        }
        return infoClientes.toString();
    }
}


public class testAsociacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto de Banco
        System.out.println("Ingrese el nombre del banco:");
        String nombreBanco = scanner.nextLine();
        Banco banco = new Banco(nombreBanco);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Mostrar Clientes del Banco");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Agregar Cliente
                    System.out.println("Ingrese el ID del cliente:");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombreCliente = scanner.nextLine();
                    System.out.println("Ingrese el apellido del cliente:");
                    String apellidoCliente = scanner.nextLine();

                    Persona nuevoCliente = new Persona(idCliente, nombreCliente, apellidoCliente);
                    banco.agregarCliente(nuevoCliente);
                    System.out.println("Cliente agregado con éxito.");
                    break;

                case 2:
                    // Buscar Cliente
                    System.out.println("Ingrese el ID del cliente a buscar:");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    Persona clienteBuscado = new Persona(idBuscar, "", "");

                    if (banco.buscarCliente(clienteBuscado)) {
                        System.out.println("Cliente encontrado:\n" + clienteBuscado.toString());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    // Mostrar Clientes del Banco
                    System.out.println(banco.toString());
                    break;

                case 4:
                    // Salir
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        scanner.close();
    }
}


