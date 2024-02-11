//Näide
public class Main {
    public static void main(String[] args) {
        //Kodus teha 3 funktsiooni milles on kasutatud vähemalt nelja erinevat tüüpi (String, int, long, char, boolean jne)
        //Teha igast funktsioonist 2 erineva sisendiga väljakutset
        double koguMaksumus1 = arvutaTaksoMaksuvus (tunnid; 3)
        System.out.println(koguMaksumus1);
        double koguMaksumus2 = arvutaTaksoMaksuvus (tunnid; 3)
        System.out.println(koguMaksumus2);
        String hinnang1 = TemperatuuriHinnang (-2, -3)
        System.out.println(hinnang1);
        String hinnang2 = TemperatuuriHinnang (-3, -5)
        System.out.println(hinnang2);
        prindiTsykkel(tahtedeArv "Pikk sõna");
        prindiTsykkel(tahtedeArv "Lyh");
    }
    private static double arvutaTaksoMaksuvus(int tunnid) {
        return 3+0.9*tunnid;
    }
    private static String TemperatuuriHinnang (double temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else {
            return "On vesi";
        }
    }
    private static void prindiTsykkel (String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.println(i);
        }
    }
}
//Kodutöö
