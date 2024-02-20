import java.util.Random;
public class Soiduk {
    int kiirus;
    String nimetus;
    int xKord;
    int yKord;
    char symbol;

    public Soiduk(int kiirus, String nimetus, Maailm maailm, Random random) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
        xKord = saaKordinaat(random, maailm.kaardiLaius);
        yKord = saaKordinaat(random, maailm.kaardiKorgus);
        symbol = 'S';
    }
    private int saaKordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
