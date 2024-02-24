public class Main {
    public static void main(String[] args) {
        //Tee kodutöö liigi champist ja info sell champi kohta ja funktsioonid updateidest kuidas statline muudetakse (vaata reference eelmine kodutöö)

        ChampionInfo championInfo = new ChampionInfo(59,640,26,30);
        Champion champion1 = new Champion(championInfo,"Ashe",450,100);
        champion1.setCostBE(1350);
        System.out.println("Ashe's new cost in blue essence is: " + champion1.costBE);

        Champion champion2 = new Champion(new ChampionInfo(60,620,30,32),
                "Yone",6300,675);
        champion2.costRPDiscount(250);
        System.out.println("Yone's cost in RP with the discount is: " + champion2.costRP);
        champion2.championInfo.setBaseAD(65);
        System.out.println("Yone's new base Attack Damage is: " + champion2.championInfo.baseAD);
    }
}