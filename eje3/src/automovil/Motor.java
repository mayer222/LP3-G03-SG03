/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automovil;

/**
 *
 * @author PC
 */

class Motor {
    private String numeroMotor;
    private int revolucionesPorMinuto;

    public Motor(String numeroMotor, int revolucionesPorMinuto) {
        this.numeroMotor = numeroMotor;
        this.revolucionesPorMinuto = revolucionesPorMinuto;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public int getRevolucionesPorMinuto() {
        return revolucionesPorMinuto;
    }

    public void setRevolucionesPorMinuto(int revolucionesPorMinuto) {
        this.revolucionesPorMinuto = revolucionesPorMinuto;
    }

    @Override
    public String toString() {
        return "Motor [Numero de Motor: " + numeroMotor + ", Revoluciones por Minuto: " + revolucionesPorMinuto + "]";
    }
}
