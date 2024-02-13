import java.util.Random;

public class Mängija {
    
    int xKord; //deklrareerin (loeb + mälukoht)
    int yKord; // Right click -> refractor -> rename
    char symbol;
    Suund suund;

    public Mängija(Random random, int kaardiKorgus, int kaardiLaius) {
        xKord = saaKordinaat(random, kaardiLaius); //initsialiseerimine, ehk annan sellele algväärtuse
        yKord = saaKordinaat(random, kaardiKorgus);
        symbol = 'x';
        suund = Suund.YLES;
    }

    //Liikumise mehhaanika
    public void liigu (String sisend, Maailm maailm){
        switch (sisend) {
            case "w" -> suund = Suund.YLES;
            case "s" -> suund = Suund.ALLA;
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        }
        switch (suund) {
            case YLES -> {
                if(yKord > 1)yKord--;
            }
            case ALLA -> {
                if(yKord < maailm.kaardiKorgus - 1)yKord++;
            }
            case VASAKULE -> {
                if(xKord > 1)xKord--;
            }
            case PAREMALE -> {
                if(xKord < maailm.kaardiLaius - 1)xKord++;
            }
        }
    }
//Main klassi sees peab olema funktsioonis static, kui on muu klassi sees siis ei tohiks olla ühelgi funktsioonil static
    private int saaKordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
