package ee.tlu.salat.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nimetus;

    @ManyToMany
    List<ToiduKomponent> toidukomponendid;
}

//GenerationType.SEQUENCE --> saan alustada mingist kindlast numbrist ja liikuda mingite kindlate numbrite võra edasi
//GenerationType.UUID --> 550e8400-e29b-41d4-a716-446655440000
//GenerationType.AUTO --> automaatselt Postgres enda seadistus
//GenerationType.TABLE --> google angle
