//Hulknurk
//
//1. Koosta klass, milles on üks massiiv kolmnurga x-koordinaatide hoidmiseks ning teine massiiv y-koordinaatide hoidmiseks. Koosta klassist kaks eksemplari, määra algväärtused ning trüki andmed välja.
//
//2. Lisa klassile käsklus punkti koordinaadipaari lisamiseks. Käsklusena väljasta tekkiva hulknurga ümbermõõt (küljepikkuste summa).
//
//3. Kuva tekkiv hulknurk graafiliselt, kirjuta külgede juurde nende pikkused ning hulknurga keskele kogu ümbermõõt.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> kolmNurk1XKords = new ArrayList<Integer>();
        kolmNurk1XKords.add(1);
        kolmNurk1XKords.add(3);
        kolmNurk1XKords.add(4);
        List<Integer> kolmNurk1YKords = new ArrayList<Integer>();
        kolmNurk1YKords.add(4);
        kolmNurk1YKords.add(3);
        kolmNurk1YKords.add(1);
        //1.
        Kolmnurk kolmnurk1 = new Kolmnurk(kolmNurk1XKords,kolmNurk1YKords);

        System.out.println(kolmnurk1.xKord);
        System.out.println(kolmnurk1.yKord);

        //2.
        int ymberm66t = kolmnurk1.lisaKordinaadid(5,10);
        System.out.println(ymberm66t);
    }
}