package ee.tlu.salat;
import lombok.Getter;
@Getter
public class championEntity {
    int baseAD;
    int baseHP;
    int baseArmor;
    int baseMagicResist;

    public championEntity(int baseAD, int baseHP, int baseArmor, int baseMagicResist) {
        this.baseAD = baseAD;
        this.baseHP = baseHP;
        this.baseArmor = baseArmor;
        this.baseMagicResist = baseMagicResist;
    }
}
