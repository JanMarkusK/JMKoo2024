import java.util.Random;
public class Ese {
    String nimetus;
    double tugevus;
    int kasutuskorrad;
    boolean aktiivne;
    int xKord;
    int yKord;
    char symbol;

    public Ese(String nimetus, double tugevus, int kasutuskorrad, Maailm maailm, Random random) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskorrad = kasutuskorrad;
        this.aktiivne = true;
        xKord = saaKordinaat(random, maailm.kaardiLaius);
        yKord = saaKordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'I';
    }
    public void hit (){
        System.out.println("Lõid vastast");
    }
    private int saaKordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
