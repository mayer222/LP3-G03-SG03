
package filehandler;

public class WordCount {
    public static void main(String[] args) throws Exception {
        WordCountFile archivo=new WordCountFile("text.txt");
        archivo.contarLines();
        archivo.contarWords();
        archivo.contarChars();
    }
}
