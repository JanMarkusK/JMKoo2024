public class Main {
    public static void main(String[] args) {
        //IDEE KODU TÖÖKS: Relva salves kuulide arvutamine ja siis vaatad kas paned salve relva sisse
        Gun gun = new Gun(30,0,400);
        Gun gun2 = new Gun(20,13,100);

        gun.magazinReloading(0);
        System.out.println("Kuule salves: " + gun.magazinCount + " Kuule järgi: " + gun.bullets);

        int bulletsAmount2 = gun2.bulletSupply(200);
        System.out.println("Kuule on " + bulletsAmount2);
    }
}