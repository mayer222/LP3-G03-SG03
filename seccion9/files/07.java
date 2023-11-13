public class DemoJFileChooser extends JFrame {
    private final JTextArea areaSalida;
    public DemoJFileChooser() throws IOException {
        super ("Demo de JFileChooser");
        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida));
        analizarRuta(); 
    }
  public void analizarRuta() throws IOException {
    // crea un objeto Path con la ruta al archivo o directorio seleccionado por el usuario
    Path ruta = obtenerRutaArchivoDirectorio();
    if (ruta != null && Files.exists(ruta)) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s:%n", ruta.getFileName()));
        builder.append(String.format("%s un directorio%n",Files.isDirectory(ruta) ? "Es" : "No es"));
        builder.append(String.format("%s una ruta absolutasn", ruta.isAbsolute() ? "Es" : "No es"));
        builder.append(String.format("Ruta: %s%n", ruta));
        builder.append(String.format("Ruta absoluta: 85%n", ruta. toAbsolutePath()));
    if (Files.isDirectory(ruta)) {
        builder.append(String. format ("§nContenido del directorio:%n"));
        DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);
        for (Path p : flujoDirectorio)
            builder.append(String. format ("%5%n", p));
        }
        areaSalida.setText(builder.toString());
    }
    else {
        JOptionPane. showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR",
            JOptionPane.ERROR_MESSAGE) ;
    }
 }
private Path obtenerRutaArchivoDirectorio() {
    JFileChooser selectorArchivos = new JFileChooser();
    selectorArchivos.setFileSelectionMode (JFileChooser.FILES_AND_DIRECTORIES) ;
    int resultado = selectorArchivos. showOpenDialog(this);
    
    if (resultado == JFileChooser. CANCEL_OPTION)
        System. exit (1);
            return selectorArchivos.getSelectedFile().toPath();
   }
}

public class PruebaJFileChooser {
    public static void main(String[] args) throws IOException {
        DemoJFileChooser aplicacion = new DemoJFileChooser();
        aplicacion. setSize (400, 400);
        aplicacion.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
        aplicacion.setVisible(true);
    }
}
