import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import java.util.Scanner;

//symbolid || == or, && == and
//shortcuttid: fori (teeb for tsükli), ifn (teeb if lause), sout (teeb print lause),
public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int kaardiKorgus = 5;
        int kaardiLaius = 10;

        int mangijaXKordinaat = saaKordinaat(random, kaardiLaius);
        int mangijaYKordinaat = saaKordinaat(random, kaardiKorgus);;
        char mangijaSymbol = 'x';

        int draakonXKordinaat = saaKordinaat(random, kaardiLaius);
        int draakonYKordinaat = 3;
        char draakonSymbol = 'D';

        int orkXKordinaat = saaKordinaat(random, kaardiLaius);
        int orkYKordinaat = saaKordinaat(random, kaardiKorgus);
        char orkSymbol = 'O';



        Scanner scanner = new Scanner(System.in); //järgmine tund

        manguKaart(kaardiKorgus, kaardiLaius, mangijaXKordinaat, mangijaYKordinaat, mangijaSymbol, draakonXKordinaat, draakonYKordinaat, draakonSymbol, orkXKordinaat, orkYKordinaat, orkSymbol);
        String sisend = scanner.nextLine();

        switch (sisend) {
            case "w" -> mangijaYKordinaat --;
            case "s" -> mangijaYKordinaat ++;
            case "a" -> mangijaXKordinaat --;
            case "d" -> mangijaXKordinaat ++;

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
        //see kahekorne tsükkel käib nt. 25 korda kuna 5 korda Y ja 5 korda x iga Y kohta
        while (!sisend.equals ("end")) { // .equals --> ==, !n.equals --> !=
            manguKaart(kaardiKorgus, kaardiLaius, mangijaXKordinaat, mangijaYKordinaat, mangijaSymbol, draakonXKordinaat, draakonYKordinaat, draakonSymbol, orkXKordinaat, orkYKordinaat, orkSymbol);
            sisend = scanner.nextLine();
            switch (sisend) {
                case "w" -> mangijaYKordinaat --;
                case "s" -> mangijaYKordinaat ++;
                case "a" -> mangijaXKordinaat --;
                case "d" -> mangijaXKordinaat ++;
            }
        }

    }

    private static void manguKaart(int kaardiKorgus, int kaardiLaius, int mangijaXKordinaat, int mangijaYKordinaat, char mangijaSymbol, int draakonXKordinaat, int draakonYKordinaat, char draakonSymbol, int orkXKordinaat, int orkYKordinaat, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol = ' ';
                //vahetan äärmised numbrid joontega et visualiseerida kasti ning kaotan sisemised arvud
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                }
                else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                }
                else {
                    if (x == mangijaXKordinaat && y == mangijaYKordinaat) {
                        symbol = mangijaSymbol;
                    }
                    else if (x == draakonXKordinaat && y == draakonYKordinaat) {
                        symbol = draakonSymbol;
                    }
                    else if (x == orkXKordinaat && y == orkYKordinaat) {
                        symbol = orkSymbol;
                    }
                    else {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int saaKordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}