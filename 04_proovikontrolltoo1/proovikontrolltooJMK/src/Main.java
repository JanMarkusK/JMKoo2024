//Libisev keskmine
//
//* 1. Koosta funktsioon kolme arvu aritmeetilise keskmise leidmiseks. Katseta.
//
//* 2. Koosta funktsioon massiivi libiseva keskmise leidmiseks. Väljundiks on massiiv, mis on sisendist kahe elemendi võrra lühem ning mille iga elemendi väärtuseks on sisendmassiivi vastava elemendi ning selle järgmise ja ülejärgmise elemendi keskmine.
//
//* 3. Koosta klass, mille eksemplarile saab vastava käsuga lisada arve. Teise käsuga saab küsida nende arvude libiseva keskmise massiivi vastavalt eelmise punkti juhendile. Koosta kood nõnda, et uue arvu lisamisel eksemplarile tehtaks uusi arvutusi võimalikult vähe (st. ei arvutataks kogu tulemust massiivi algusest uuesti)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1.
        double kesk = arvutaAritmKeskmine(4, 3, 8);
        System.out.println("1. " + kesk);

        //2.
        List<Double> arvud = new ArrayList<>();
        arvud.add(4.0);
        arvud.add(3.0);
        arvud.add(8.0);
        List<Double> libisevKesk = arvutaLibisevKeskmine(arvud);
        System.out.println("2. " +libisevKesk);

        //3.
        LibisevKeskmine keskmine1 = new LibisevKeskmine(arvud);
        List<Double>libisevKesk2 = keskmine1.saabArvudKeskmised();
        System.out.println("3.1 " +libisevKesk2);
        keskmine1.lisaArv(10.0);
        List<Double>libisevKesk3 = keskmine1.saabArvudKeskmised();
        System.out.println("3.2 " +libisevKesk3);

    }
    // private static --> kui funktsioon kutsutakse mainis
    // public --> kui loon funktsiooni teises klassis
    //1.
    private static double arvutaAritmKeskmine(double arv1, double arv2, double arv3) {
        double summa = arv1 + arv2 + arv3;
        double aritmKesk = summa /3;
        return aritmKesk;
    }
    //2.
    private static List<Double> arvutaLibisevKeskmine(List<Double> arvud) {
        List<Double> arvudKeskmised = new ArrayList<>();

        for (int i = 0; i < arvud.size() - 2; i++) {
           double summa = arvud.get(i) + arvud.get(i+1) + arvud.get(i+2);
           double libisevKeskmine = summa/3;
           arvudKeskmised.add(libisevKeskmine);


        }
        return arvudKeskmised;
    }
}