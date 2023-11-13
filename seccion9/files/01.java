import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class File11 {
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escriba el nombre del archivo o directorio:");
    Path ruta = Paths.get(sc.nextLine());
    if (Files.exists(ruta) ) {
        System.out.printf("%n%s existe%n", ruta.getFileName());
        System.out.printf("%s un directorio%n", Files.isDirectory(ruta)? "Es" : "No es");
        System.out.printf("%s una ruta absolutasn", ruta.isAbsolute()? "Es" : "No es");
        System.out.printf("Fecha de ultima modificacion: %s%n", Files.getLastModifiedTime( ruta));
        System.out.printf("Tamanio: 85%n", Files.size(ruta));
        System.out.printf("Ruta: %5%n", ruta);
        System.out.printf("Ruta absoluta: ⅘5%n", ruta. toAbsolutePath());
        if ( Files.isDirectory(ruta)) {
            System.out.printf("enContenido del directorio:%n");
            DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream (ruta);
        for (Path p : flujoDirectorio)
            System. out.println(p);
        }
    }
    else {
         System.out.printf ("es no exite%n", ruta);
    }}}
