public class ChampionInfo {
    int baseAD;
    int baseHP;
    int baseArmor;
    int baseMagicResist;

    public ChampionInfo(int baseAD, int baseHP, int baseArmor, int baseMagicResist) {
        this.baseAD = baseAD;
        this.baseHP = baseHP;
        this.baseArmor = baseArmor;
        this.baseMagicResist = baseMagicResist;
    }

    public void setBaseAD(int baseAD) {
        this.baseAD = baseAD;
    }
}
