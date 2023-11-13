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
    private String numMotor;
    private int revolucionesPorMinuto;

    public Motor(String numMotor, int revolucionesPorMinuto) {
        this.numMotor = numMotor;
        this.revolucionesPorMinuto = revolucionesPorMinuto;
    }

    public String getnumMotor() {
        return numMotor;
    }

    public void setnumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public int getRevolucionesPorMinuto() {
        return revolucionesPorMinuto;
    }

    public void setRevolucionesPorMinuto(int revolucionesPorMinuto) {
        this.revolucionesPorMinuto = revolucionesPorMinuto;
    }

    @Override
    public String toString() {
        return "Motor [num de Motor: " + numMotor + ", Revoluciones por Minuto: " + revolucionesPorMinuto + "]";
    }
}
