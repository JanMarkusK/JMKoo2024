import java.util.Random;

public class Draakon extends Tegelane implements JuhuslikKordinaat{


    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        xKord = saaKordinaat(random, kaardiLaius); //initsialiseerimine, ehk annan sellele algväärtuse
        yKord = saaKordinaat(random, kaardiKorgus);
        symbol = 'D';
    }
    public int saaKordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
