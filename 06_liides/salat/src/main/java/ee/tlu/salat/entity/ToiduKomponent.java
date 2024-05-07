package ee.tlu.salat.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Koosneb toiduainest ja temaga seotud kogusega roas
//Klassikomplekt -> kartul+omadused ja mitugrammi

//@AllArgsConstructor on java constructori eest, automaatselt teeb seda
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToiduKomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    ToiduaineEntity toiduaine;
    @ManyToOne
    Toit toit;
    int kogus;

    //@ManyToMany
    //List<ToiduaineEntity> toiduained;
    // {id: 5 , toiduaine: {nimetus:"Vorst}, kogus: 100}
}
