import java.util.List;

public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;
    public Maailm (int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }
    public void manguKaart(List<Tegelane> tegelased, List<Ese> esemed) {
        //see kahekorne tsükkel käib nt. 25 korda kuna 5 korda Y ja 5 korda x iga Y kohta
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol = ' ';
                //vahetan äärmised numbrid joontega et visualiseerida kasti ning kaotan sisemised arvud
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    for (Ese e : esemed) {
                        if (e.xKord == x && e.yKord == y) {
                                symbol = e.symbol;
                        }
                    }
                    for (Tegelane t: tegelased) {
                        if (t.xKord == x && t.yKord == y) {
                            symbol = t.symbol;
                        }
                    }
                        //Teine versioon for tsükklist
                        //for (int i = 0; i < esemed.size(); i++) {
                        //    esemed.get(i);
                        //}
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
