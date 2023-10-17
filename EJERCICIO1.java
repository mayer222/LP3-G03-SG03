abstract class Figura {
    public abstract double obtenerArea();
    public abstract double obtenerVolumen();
}
abstract class FiguraBidimensional extends Figura {
    // Clase abstracta para figuras bidimensionales
}
abstract class FiguraTridimensional extends Figura {
    // Clase abstracta para figuras tridimensionales
}
class Circulo extends FiguraBidimensional {
    private double radio;
    public Circulo(double radio) {
        this.radio = radio;
    }
    @Override
    public double obtenerArea() {
        return Math.PI * radio * radio;
    }
    @Override
    public double obtenerVolumen() {
        return 0.0; // No se usa en figuras bidimensionales
   }
}
class Cuadrado extends FiguraBidimensional {
    private double lado;
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    @Override
    public double obtenerArea() {
        return lado * lado;
    }
    @Override
    public double obtenerVolumen() {
        return 0.0; // No se usa en figuras bidimensionales
    }
}
class Triangulo extends FiguraBidimensional {
    private double base;
    private double altura;
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double obtenerArea() {
        return (base * altura) / 2;
    }
    @Override
    public double obtenerVolumen() {
        return 0.0; // No se usa en figuras bidimensionales
    }
}
class Esfera extends FiguraTridimensional {
    private double radio;
    public Esfera(double radio) {
        this.radio = radio;
    }
    @Override
    public double obtenerArea() {
        return 4 * Math.PI * radio * radio;
    }
    @Override
    public double obtenerVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }
}
class Cubo extends FiguraTridimensional {
    private double lado;
    public Cubo(double lado) {
        this.lado = lado;
    }
    @Override
    public double obtenerArea() {
        return 6 * lado * lado;
    }
    @Override
    public double obtenerVolumen() {
        return Math.pow(lado, 3);
    }
}
class Tetraedro extends FiguraTridimensional {
    private double arista;

    public Tetraedro(double arista) {
        this.arista = arista;
    }
    @Override
    public double obtenerArea() {
        return 4 * (arista * arista * Math.sqrt(3)) / 4;
    }
    @Override
    public double obtenerVolumen() {
        return (Math.pow(arista, 3)) / (6 * Math.sqrt(2));
    }
}
public class Main {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[6];
        figuras[0] = new Circulo(5.0);
        figuras[1] = new Cuadrado(4.0);
        figuras[2] = new Triangulo(3.0, 4.0);
        figuras[3] = new Esfera(3.0);
        figuras[4] = new Cubo(2.0);
        figuras[5] = new Tetraedro(2.0);
        for (Figura figura : figuras) {
            System.out.println(figura.getClass().getSimpleName() + ":");
            System.out.println("Área: " + figura.obtenerArea());
            System.out.println("Volumen: " + figura.obtenerVolumen());
            System.out.println();
        }
    }
}