/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filehandler;
import java.io.IOException;


public class WordCountFile extends FileHandler {
    WordCountFile(String filepath) {
        super(filepath);
        try {
            super.createFile();
        } catch (IOException e) {
            e.printStackTrace(); // o maneja de otra manera (log, mensaje, etc.)
        }
    }

    int contarLines() throws IOException {
        String contenido = readFromFile();
        String[] lineas = contenido.split("\n");
        int cantLines=0;

        // Limpiar la tabla antes de agregar nuevas filas

        for (String linea : lineas) {
            cantLines++;

        }
        System.out.println("lines = "+cantLines);
        return cantLines;
    }
    int contarWords() throws IOException{
        String contenido = readFromFile();
        String[] lineas = contenido.split("\n");
        int cantWords=0;

        // Limpiar la tabla antes de agregar nuevas filas

        for (String linea : lineas) {
            String[] words=linea.split(" ");
            for(String word:words){
                cantWords++;
            }

        }

        System.out.println("words = "+cantWords);
        
        return cantWords;
    }

    int contarChars()throws IOException{
        String contenido = readFromFile();
        String[] lineas = contenido.split("\n");
        int cantChars=0;

        // Limpiar la tabla antes de agregar nuevas filas

        for (String linea : lineas) {
            String line=linea.split("\n")[0];

            for(char chars:line.toCharArray()){
                cantChars++;
            }

        }

        System.out.println("chars = "+cantChars);
        return cantChars;
    }

}
