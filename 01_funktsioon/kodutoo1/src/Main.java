public class Main {
    public static void main(String[] args) {
        //Kodus teha 3 funktsiooni milles on kasutatud vähemalt nelja erinevat tüüpi (String, int, long, char, boolean jne)
        //Teha igast funktsioonist 2 erineva sisendiga väljakutset

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