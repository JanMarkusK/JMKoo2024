package ee.tlu.salat.Champion;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "champion-stats") //selleks, et vahetada AB tabeli nime
@Entity // AB'ga suhtlemiseks
@AllArgsConstructor
@NoArgsConstructor // AB'sse panekuks
public class ChampionEntity {
    @Id
    int baseAD;
    int baseHP;
    int baseArmor;
    int baseMagicResist;
}
