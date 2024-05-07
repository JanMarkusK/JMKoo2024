package ee.tlu.kontrolltoo2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimetus;
    private int avamisAeg;
    private int sulgemisAeg;
    private int kulastunuteArv;
    @ManyToOne
    private Kaubanduskeskus kaubanduskeskus;
}
