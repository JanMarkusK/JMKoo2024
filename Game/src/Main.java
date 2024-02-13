import java.util.Random;
import java.util.Scanner;

//symbolid || == or, && == and
//shortcuttid: fori (teeb for tsükli), ifn (teeb if lause), sout (teeb print lause),
public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        Maailm maailm = new Maailm(5,10);
        Mängija mängija = new Mängija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        Scanner scanner = new Scanner(System.in); //järgmine tund

        maailm.manguKaart(mängija, draakon, ork);
        String sisend = scanner.nextLine();

        mängija.liigu(sisend, maailm);

        //see kahekorne tsükkel käib nt. 25 korda kuna 5 korda Y ja 5 korda x iga Y kohta
        while (!sisend.equals ("end")) { // .equals --> ==, !n.equals --> !=
            maailm.manguKaart(mängija, draakon, ork);
            sisend = scanner.nextLine();
            mängija.liigu(sisend, maailm);
        }
    }
}


// if versioon switchist
//        if (sisend.equals("w")) {
//            mangijaYKordinaat = --;
//        } else if (sisend.equals("s")) {
//            mangijaYKordinaat = ++;
//        } else if (sisend.equals("a")) {
//            mangijaXKordinaat = --;
//        } else if (sisend.equals("d")) {
//            mangijaXKordinaat = ++;
//        }