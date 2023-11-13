import java.io.*;
public class Alumno extends Persona{
    private Fecha fechaMatricula;
    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super (nif, nombre, edad);
        this. fechaMatricula = new Fecha();
        setFechaMatricula(fechaMatricula);
    }
    public Alumno() {}
    public Fecha getFechaMatricula() {
        return fechaMatricula;}
    public void setFechaMatricula(Fecha fechaMatricula) {
        this .fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes (fechaMatricula.getMes());
        this. fechaMatricula. setAño (fechaMatricula. getAño());
 }}
public class Fecha implements Serializable{
    private int dia;
    private int mes;
    private int año;
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    public Fecha(){}
    public int getAño() {
        return año;}
    public void setAño(int año) {
        this.año = año;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia; }
    public int getMes() {
        return mes;}
    public void setMes(int mes) {
        this.mes = mes;}
    }
}


public class Serial5 {
public static void main(String[] args) throws IOException {
    FileOutputStream fos = null;
    ObjectOutputStream salida = null;
    Alumno a;
    Fecha f;
    try {
        fos = new FileOutputStream(" /ficheros/alumnos.dat");
        salida = new ObjectOutputStream(fos);
        f = new Fecha (5, 9,2011);
        a = new Alumno ("12345678A", "Lucas González", 20, f);
        salida.writeObject(a);
        f = new Fecha (7,9,2011);
        a = new Alumno ("98765432B" , "Anacleto Jiménez", 19, f);
        salida.writeObject(a);
        f = new Fecha (8,9,2011);
        a = new Alumno ("782342122" , "María Zapata", 21, f);
        salida.writeObject(a);
    }catch (FileNotFoundException e) {
        System.out. println(e.getMessage ());
    }catch (IOException e) {
        System. out. println(e. getMessage ( ));
    }finally {
        try {
        if (fos!=null) fos.close();
        if (salida!=null) salida.close();
        } catch (IOException e) {
            System.out.println(e. getMessage());
            }
        }
    }
}
