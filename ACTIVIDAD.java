interface PorPagar {
    double obtenerMontoPago();}
class Factura implements PorPagar {
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;
    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo) {
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        establecerCantidad(cantidad);
        establecerPrecioPorArticulo(precioPorArticulo);}
    public void establecerCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
    }
    public void establecerPrecioPorArticulo(double precioPorArticulo) {
        if (precioPorArticulo >= 0) {
            this.precioPorArticulo = precioPorArticulo;
        } else {
            throw new IllegalArgumentException("El precio por artículo no puede ser negativo.");
        }
    }
    public double obtenerCantidad() {
        return cantidad;
    }
    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }
    @Override
    public double obtenerMontoPago() {
        return obtenerCantidad() * obtenerPrecioPorArticulo();
    }
    @Override
    public String toString() {
        return String.format("Factura:\nNúmero de pieza: %s (%s)\nCantidad: %d\nPrecio por artículo: $%.2f", numeroPieza, descripcionPieza, cantidad, precioPorArticulo);
    }
}
abstract class Empleado implements PorPagar {
    private String primerNombre;
    private String apellidoPaterno;
    private String numeroDeSeguroSocial;
    public Empleado(String primerNombre, String apellidoPaterno, String numeroDeSeguroSocial) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroDeSeguroSocial = numeroDeSeguroSocial;
    }
    @Override
    public String toString() {
        return String.format("Empleado:\nNombre: %s %s\nNúmero de seguro social: %s", primerNombre, apellidoPaterno, numeroDeSeguroSocial);
    }
}
class EmpleadoAsalariado extends Empleado {
    private double salarioSemanal;
    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno, String numeroDeSeguroSocial, double salarioSemanal) {
        super(primerNombre, apellidoPaterno, numeroDeSeguroSocial);
        establecerSalarioSemanal(salarioSemanal);
    }
    public void establecerSalarioSemanal(double salarioSemanal) {
        if (salarioSemanal >= 0) {
            this.salarioSemanal = salarioSemanal;
        } else {
            throw new IllegalArgumentException("El salario semanal no puede ser negativo.");
        }
    }
    public double obtenerSalarioSemanal() {
        return salarioSemanal;
    }
    @Override
    public double obtenerMontoPago() {
        return obtenerSalarioSemanal();
    }
}
//clase prestamo
class Prestamo implements PorPagar {
    private int numeroDeCuotas;
    private double montoDeCuota;
    public Prestamo(int numeroDeCuotas, double montoDeCuota) {
        this.numeroDeCuotas = numeroDeCuotas;
        this.montoDeCuota = montoDeCuota;
    }
    public int getNumeroDeCuotas() {
        return numeroDeCuotas;
    }
    public void setNumeroDeCuotas(int numeroDeCuotas) {
        this.numeroDeCuotas = numeroDeCuotas;
    }
    public double getMontoDeCuota() {
        return montoDeCuota;
    }
    public void setMontoDeCuota(double montoDeCuota) {
        this.montoDeCuota = montoDeCuota;
    }
    @Override
    public double obtenerMontoPago() {
        return numeroDeCuotas * montoDeCuota;
    }
    @Override
    public String toString() {
        return String.format("Prestamo:\nNúmero de cuotas: %d\nMonto de cuota: $%.2f", numeroDeCuotas, montoDeCuota);
    }
}
class PruebaInterfazPorPagar {
    public static void main(String[] args) {
        PorPagar[] objetosPorPagar = new PorPagar[5];
        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("56789", "llanta", 4, 79.95);
        objetosPorPagar[2] = new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        objetosPorPagar[3] = new EmpleadoAsalariado("Lisa", "Barnes", "888-88-8888", 1200.00);
        objetosPorPagar[4] = new Prestamo(12, 500.00); // Agregamos un objeto de la clase Prestamo
        System.out.println("Facturas, empleados y préstamo procesados en forma polimórfica\n");
        for (PorPagar porPagarActual : objetosPorPagar) {
            System.out.printf("%s\nPago vencido: $%.2f\n\n", porPagarActual, porPagarActual.obtenerMontoPago());
        }
    }
}
