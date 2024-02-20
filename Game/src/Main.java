import java.util.ArrayList;
import java.util.List;
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

        List<Tegelane> tegelased = new ArrayList<>();
        tegelased.add(mängija);
        tegelased.add(draakon);
        tegelased.add(ork);

        Ese mõõk = new Ese("Mõõk",10,5, maailm, random);
        Ese haamer = new Ese("Haamer",7,10, maailm, random);
        Ese saabas = new Ese("Saabas",2,5, maailm, random);
        List<Ese> esemed = new ArrayList<>();
        esemed.add(mõõk);
        esemed.add(haamer);
        esemed.add(saabas);

        Soiduk soiduk = new Soiduk (1,"Hobune", maailm, random);
        Scanner scanner = new Scanner(System.in); //järgmine tund

        maailm.manguKaart(tegelased, esemed);
        String sisend = scanner.nextLine();

        mängija.liigu(sisend, maailm);

        while (!sisend.equals ("end")) { // .equals --> ==, !n.equals --> !=
            maailm.manguKaart(tegelased, esemed);
            sisend = scanner.nextLine();
            mängija.liigu(sisend, maailm);
            for (Ese e : esemed) {
                if (mängija.xKord == e.xKord && mängija.yKord == e.yKord) {
                    mängija.ese = e;
                    System.out.println("Korjasid üles eseme " + e.nimetus);
                    break;
                }
            }
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