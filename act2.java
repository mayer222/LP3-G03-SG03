class Motor {
    private int numMotor;
    private int revPorMin;
    public Motor(int numMotor, int revPorMin) {
        this.numMotor = numMotor;
        this.revPorMin = revPorMin;
    }
    public int getNumMotor() {
        return numMotor;
    }
    public void setNumMotor(int numMotor) {
        this.numMotor = numMotor;
    }
    public int getRevPorMin() {
        return revPorMin;
    }
    public void setRevPorMin(int revPorMin) {
        this.revPorMin = revPorMin;
    }

    @Override
    public String toString() {
        return "Motor [numMotor=" + numMotor + ", revPorMin=" + revPorMin + "]";
    }
}
class Automovil {
    private String placa;
    private int numPuertas;
    private String marca;
    private String modelo;
    private Motor motor;
    public Automovil(String placa, int numPuertas, String marca, String modelo) {
        this.placa = placa;
        this.numPuertas = numPuertas;
        this.marca = marca;
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    // método toString
    @Override
    public String toString() {
        return "Automovil [placa=" + placa + ", numPuertas=" + numPuertas + ", marca=" + marca + ", modelo=" + modelo
                + ", motor=" + motor + "]";
    }
}
public class TestAgregacion {
    public static void main(String[] args) {
        //  objeto Motor
        Motor motor1 = new Motor(12345, 3000);
        // cear un objeto Automovil y asignarle el motor
        Automovil automovil1 = new Automovil("ABC123", 4, "Toyota", "Camry");
        automovil1.setMotor(motor1);
        // información del automóvil
        System.out.println("Información del Automóvil 1:");
        System.out.println(automovil1.toString());
    }
}