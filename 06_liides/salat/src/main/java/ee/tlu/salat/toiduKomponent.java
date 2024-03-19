package ee.tlu.salat;


import lombok.AllArgsConstructor;
import lombok.Getter;

//Koosneb toiduainest ja temaga seotud kogusega roas
//Klassikomplekt -> kartul+omadused ja mitugrammi

//@AllArgsConstructor on java constructori eest, automaatselt teeb seda
@Getter
@AllArgsConstructor
public class toiduKomponent {
    ToiduaineEntity toiduaine;
    int kogus;
}
