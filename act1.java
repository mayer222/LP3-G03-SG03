class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        // Determinar el número de cuenta
        this.cuenta = new Cuenta(id);
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cuenta=" + cuenta + "]";
    }
}
class Cuenta {
    private int numero;
    private double saldo;
    public Cuenta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String toString() {
        return "Cuenta [numero=" + numero + ", saldo=" + saldo + "]";
    }
}
public class TestComposicion {
    public static void main(String[] args) {
        // Crear objetos de Persona
        Persona persona1 = new Persona(1, "Juan", "Pérez");
        Persona persona2 = new Persona(2, "María", "López");

        // Mostrar información de las personas y sus cuentas
        System.out.println("Información de la Persona 1:");
        System.out.println(persona1.toString());
        System.out.println("\nInformación de la Persona 2:");
        System.out.println(persona2.toString());
    }
}