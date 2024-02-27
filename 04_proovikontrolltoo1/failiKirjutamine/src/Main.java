import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new PrintWriter("väljund.txt"));
        pw.print("Elas");
        pw.print(" ");
        pw.print("metsas");
        pw.print(" ");
        // \n on linebreak ehk järgmine asi alustab uuelt realt
        pw.print("muttionu\n");
        pw.println("keset kuuski noor vanu");
        pw.close();
    }
}