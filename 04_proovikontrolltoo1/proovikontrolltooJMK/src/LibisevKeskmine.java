import java.util.ArrayList;
import java.util.List;
//3.
public class LibisevKeskmine {
    List<Double> arvud = new ArrayList<>(); //eksemplar
    List<Double> arvudKeskmised = new ArrayList<>();

    public LibisevKeskmine(List<Double> arvudAlguses) {
        this.arvud = arvudAlguses; //[4,3,8]
        arvutaLibisevKeskmine();    //[5.0]
    }


    // vastav käsk   eksemplarile saab vastava käsuga lisada arve
    public void lisaArv(Double arv) {
        double viimane = arvud.get(arvud.size()-1);
        double eelViimane = arvud.get(arvud.size()-2);
        double keskmine = (viimane + eelViimane + arv) /3;
        arvudKeskmised.add(keskmine);
        arvud.add(arv);
    }
    //Teise käsuga saab küsida nende arvude libiseva keskmise massiivi
    public List<Double> saabArvudKeskmised() {
        return arvudKeskmised;
    }

    private List<Double> arvutaLibisevKeskmine() {
        for (int i = 0; i < arvud.size() - 2; i++) {
            double summa = arvud.get(i) + arvud.get(i+1) + arvud.get(i+2);
            double libisevKeskmine = summa/3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;
    }
}
