/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java;

/**
 *
 * @author PC
 */

import java.util.ArrayList;

// Interfaz ImpactoEcologico
interface ImpactoEcologico {
    double obtenerImpactoEcologico();
}

// Clase Edificio
class Edificio implements ImpactoEcologico {
    private double consumoEnergetico; // Atributo específico de Edificio

    public Edificio(double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    @Override
    public double obtenerImpactoEcologico() {
        double DATO_ACTIVIDAD = consumoEnergetico;
        double FACTOR_DE_EMISION = 0.5;
        return DATO_ACTIVIDAD * FACTOR_DE_EMISION;
    }
}

// Clase Auto
class Auto implements ImpactoEcologico {
    private double emisionesAnuales; // Atributo específico de Auto

    public Auto(double emisionesAnuales) {
        this.emisionesAnuales = emisionesAnuales;
    }

    @Override
    public double obtenerImpactoEcologico() {
        double DATO_ACTIVIDAD = emisionesAnuales;
        double FACTOR_DE_EMISION = 0.3;
        return DATO_ACTIVIDAD * FACTOR_DE_EMISION;
    }
}

// Clase Bicicleta
class Bicicleta implements ImpactoEcologico {
    private int distanciaRecorrida; // Atributo específico de Bicicleta

    public Bicicleta(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    @Override
    public double obtenerImpactoEcologico() {
        double DATO_ACTIVIDAD = distanciaRecorrida;
        double FACTOR_DE_EMISION = 0.05;
        return DATO_ACTIVIDAD * FACTOR_DE_EMISION;
    }
}

public class EEJERCICIO2 {
    public static void main(String[] args) {
        // Crear objetos de las clases
        Edificio edificio = new Edificio(5000);
        Auto auto = new Auto(10000);
        Bicicleta bicicleta = new Bicicleta(500);

        // Crear un ArrayList de ImpactoEcologico y agregar los objetos
        ArrayList<ImpactoEcologico> impactoEcologicoList = new ArrayList<>();
        impactoEcologicoList.add(edificio);
        impactoEcologicoList.add(auto);
        impactoEcologicoList.add(bicicleta);

        // Calcular y mostrar el impacto ecológico de cada objeto
        for (ImpactoEcologico objeto : impactoEcologicoList) {
            System.out.println("Tipo de objeto: " + objeto.getClass().getSimpleName());
            System.out.println("Impacto Ecológico: " + objeto.obtenerImpactoEcologico());
            System.out.println();
        }
    }
}
