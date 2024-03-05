//Šifreerija/dešifreerija (cipher, decipher)
//
//* Luua klass, mis muudaks ette antava lause tähestiku ulatuses mingisuguse nihkega arusaamatuks (näiteks nihe 1, kus kõik “a”-d muudetakse “b”-deks, “d”-d muudetakse “e”-deks jne)
//* Samuti eksisteeriks ka dešifreerija, et võimalik nihke ette andmisel funktsiooni selle sama sisendi tagasi muutma arusaadavaks
//* Lugeda failist esimesel real oleva nihke numbri ning ülejäänud read selle nihke abil šifreerida ning salvestada šifreeritud kujul teise faili.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws IOException {
        //faili lugemise ja kirjutamise setup
        BufferedReader br = new BufferedReader(new FileReader("message.txt"));
        int fileOffset = Integer.parseInt(br.readLine()); //leiab esimesest reast soovitud väärtuse
        PrintWriter pw = new PrintWriter(new PrintWriter("output.txt"));

        //1. punkt
        Cipher cipher = new Cipher("Come out ye black and tans",27);
        String sifreeritudText = cipher.encrypt(cipher.message, cipher.offset);
        System.out.println("Tekst: " + cipher.message);
        System.out.println("Tekst krüpteeritud: " + sifreeritudText);
        //2. punkt
        String dekrypteeritudText = cipher.decrypt(sifreeritudText, cipher.offset);
        System.out.println("Tekst dekrüpteeritud: " + dekrypteeritudText + "\n");

        //3. punkt. Failist teksti lugemine ja krüpteeritud teksti teise faili kirjutamine
        String rida = br.readLine(); //See loeb esimese rea (mis meil on arv/offset) seega järgnev on tekst ja ei pea midagi kontrollima
        while (rida != null){
            System.out.println("Faili rida: " + rida);
            String cipherLine = cipher.encrypt(rida, fileOffset);
            pw.println(cipherLine);
            rida = br.readLine();
        }
        br.close();
        pw.close();
    }
}