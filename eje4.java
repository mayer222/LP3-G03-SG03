import java.util.Scanner;
class Asalariado {
    private String nombre;
    private long dni;
    private int diasVacaciones;
    private double salarioBase;
    public Asalariado(String nombre, long dni, int diasVacaciones, double salarioBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.diasVacaciones = diasVacaciones;
        this.salarioBase = salarioBase;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }
    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    // metodo toString
    @Override
    public String toString() {
        return "Empleado asalariado\n" +
                "DNI: " + dni + "\n" +
                "Nombre: " + nombre + "\n" +
                "Vacaciones: " + diasVacaciones + " días\n" +
                "Salario: $" + salarioBase;
    }
}
class EmpleadoProduccion extends Asalariado {
    public EmpleadoProduccion(String nombre, long dni, int diasVacaciones, double salarioBase) {
        super(nombre, dni, diasVacaciones, salarioBase);
    }
    // Método toString
    @Override
    public String toString() {
        return "Empleado de producción\n" + super.toString();
    }
}
class EmpleadoDistribucion extends Asalariado {
    private String zona;
    // Constructor
    public EmpleadoDistribucion(String nombre, long dni, int diasVacaciones, double salarioBase, String zona) {
        super(nombre, dni, diasVacaciones, salarioBase);
        this.zona = zona;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }

    // Método toString
    @Override
    public String toString() {
        return "Empleado de distribución\n" +
                "DNI: " + getDni() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Vacaciones: " + getDiasVacaciones() + " días\n" +
                "Salario: $" + getSalarioBase() + "\n" +
                "Zona: " + zona;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de empleado (Asalariado/Produccion/Distribucion): ");
        String tipoEmpleado = scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI: ");
        long dni = scanner.nextLong();
        System.out.print("Ingrese los días de vacaciones: ");
        int diasVacaciones = scanner.nextInt();
        System.out.print("Ingrese el salario base: ");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine();
        if (tipoEmpleado.equalsIgnoreCase("Asalariado")) {
            Asalariado empleado = new Asalariado(nombre, dni, diasVacaciones, salarioBase);
            System.out.println(empleado.toString());
        } else if (tipoEmpleado.equalsIgnoreCase("Produccion")) {
            EmpleadoProduccion empleado = new EmpleadoProduccion(nombre, dni, diasVacaciones, salarioBase);
            System.out.println(empleado.toString());
        } else if (tipoEmpleado.equalsIgnoreCase("Distribucion")) {
            System.out.print("Ingrese la zona: ");
            String zona = scanner.nextLine();
            EmpleadoDistribucion empleado = new EmpleadoDistribucion(nombre, dni, diasVacaciones, salarioBase, zona);
            System.out.println(empleado.toString());
        } else {
            System.out.println("Tipo de empleado no válido.");
        }
        scanner.close();


        //pruebas de herencia
        Asalariado asalariado = new Asalariado("Juan", 123456789, 10, 3000.0);
        EmpleadoProduccion empleadoProduccion = new EmpleadoProduccion("Ana", 987654321, 5, 2500.0);
        EmpleadoDistribucion empleadoDistribucion = new EmpleadoDistribucion("Carlos", 456789123, 7, 3500.0, "Centro");

        // Imprimir información de las instancias
        System.out.println("Información del asalariado:");
        System.out.println(asalariado.toString());

        System.out.println("\nInformación del empleado de producción:");
        System.out.println(empleadoProduccion.toString());

        System.out.println("\nInformación del empleado de distribución:");
        System.out.println(empleadoDistribucion.toString());
    }
}
