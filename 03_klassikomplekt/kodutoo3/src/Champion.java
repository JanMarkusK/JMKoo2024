public class Champion {
    ChampionInfo championInfo;
    String name;
    int costBE;
    int costRP;

    public Champion(ChampionInfo championInfo, String name, int costBE, int costRP) {
        this.championInfo = championInfo;
        this.name = name;
        this.costBE = costBE;
        this.costRP = costRP;
    }

    public void setCostBE(int costBE) {
        this.costBE = costBE;
    }
    public void costRPDiscount(int discount) {
        this.costRP = this.costRP - discount;
    }
}
