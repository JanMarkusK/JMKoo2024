import java.util.Random;

public class Ork extends Tegelane implements JuhuslikKordinaat{


    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        xKord = saaKordinaat(random, kaardiLaius); //initsialiseerimine, ehk annan sellele algväärtuse
        yKord = saaKordinaat(random, kaardiKorgus);
        symbol = 'O';
    }

    public int saaKordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
