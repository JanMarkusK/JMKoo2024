package ee.tlu.salat.Champion;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne//kui kustutakse toiduaine, siis kustuvad ka temaga seotud toidu kompnendid
    ChampionEntity championEntity;
    String name;
    int beCost;
}