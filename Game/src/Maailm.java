public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;
    public Maailm (int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }
    public void manguKaart(Mängija mängija, Draakon draakon, Ork ork) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol = ' ';
                //vahetan äärmised numbrid joontega et visualiseerida kasti ning kaotan sisemised arvud
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mängija.xKord && y == mängija.yKord) {
                        symbol = mängija.symbol;
                    } else if (x == draakon.xKord && y == draakon.yKord) {
                        symbol = draakon.symbol;
                    } else if (x == ork.xKord && y == ork.yKord) {
                        symbol = ork.symbol;
                    } else {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
