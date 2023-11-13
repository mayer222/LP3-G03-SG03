
package filehandler;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler{
    protected Path filePath;

    public FileHandler(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public void createFile() throws IOException {
        try {
            Files.createFile(this.filePath);
            System.out.println("Archivo creado: " + this.filePath.toAbsolutePath());
        } catch (FileAlreadyExistsException e) {
            System.out.println("File: "+this.filePath.getFileName());
        }
    }
    public void writeToFile(String content) throws IOException {
        Files.write(filePath, content.getBytes(),StandardOpenOption.APPEND);
        System.out.println("Contenido escrito en el archivo.");
    }

    public String readFromFile() throws IOException {
        return new String(Files.readAllBytes(filePath));
    }
}