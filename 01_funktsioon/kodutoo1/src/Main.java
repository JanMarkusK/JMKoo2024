public class Main {
    public static void main(String[] args) {
        //Kodus teha 3 funktsiooni milles on kasutatud vähemalt nelja erinevat tüüpi (String, int, long, char, boolean jne)
        //Teha igast funktsioonist 2 erineva sisendiga väljakutset
        //Näited
        double koguMaksumus1 = arvutaTaksoMaksuvus (3);
        System.out.println(koguMaksumus1);
        double koguMaksumus2 = arvutaTaksoMaksuvus (4);
        System.out.println(koguMaksumus2);

        String hinnang1 = TemperatuuriHinnang (2.2);
        System.out.println(hinnang1);
        String hinnang2 = TemperatuuriHinnang (-2.1);
        System.out.println(hinnang2);

        prindiTsykkel("Pikk sõna");
        prindiTsykkel("Lyh");

        //Kodutöö
        sonaLeidmine("elu");
        sonaLeidmine("muu sõna");

        int summa1 = viiegaLiitmine (1);
        System.out.println(summa1);
        int summa2 = viiegaLiitmine (3);
        System.out.println(summa2);

        double kartuliMaksumus1 = kartuliHind(8);
        System.out.println(kartuliMaksumus1);
        double kartuliMaksumus2 = kartuliHind(11);
        System.out.println(kartuliMaksumus2);
    }
    //Näited
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
    //Kodutöö
    private static void sonaLeidmine(String sona) {
        if (sona.equals("elu")) {
            System.out.println("Leidsid õige sõna");
        } else {
            System.out.println("Ei vedanud");
        }
    }
    public static int viiegaLiitmine(int arv) {
        return 5+arv;
    }
    public static double kartuliHind (int kartuliteArv) {
        return 0.56 * kartuliteArv;
    }
}