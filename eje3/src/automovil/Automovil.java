/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automovil;

/**
 *
 * @author PC
 */
class Automovil {
    private String placa;
    private int numeroPuertas;
    private String marca;
    private String modelo;
    private Motor motor;

    public Automovil(String placa, int numeroPuertas, String marca, String modelo) {
        this.placa = placa;
        this.numeroPuertas = numeroPuertas;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
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

    @Override
    public String toString() {
        return "Automovil [Placa: " + placa + ", Numero de Puertas: " + numeroPuertas + ", Marca: " + marca + ", Modelo: " + modelo + ", Motor: " + motor + "]";
    }
}

