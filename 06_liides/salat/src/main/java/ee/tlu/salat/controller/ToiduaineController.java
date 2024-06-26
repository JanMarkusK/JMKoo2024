package ee.tlu.salat.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
//@CrossOrigin("*")
public class ToiduaineController {
    List<String> toiduained = new ArrayList<>();
    @GetMapping("toiduained")
    public List<String> saaToiduaine (){
        return toiduained;
    }
    @PostMapping("toiduained/{toiduaine}")
    public List<String> lisaToiduaine (@PathVariable String toiduaine){
        toiduained.add(toiduaine);
        return toiduained;
    }
    @DeleteMapping("toidained/{index}")
    public List<String> kustutaToiduaine (@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }
    @PutMapping("toidained/{index}/{newValue}")
    public List<String> muudaToiduaine (
            @PathVariable int index,
            @PathVariable String newValue){
        toiduained.set(index, newValue);
        return toiduained;
    }
    @GetMapping("toiduained/{index}")
    public String saaToiduaine (@PathVariable int index){
        return toiduained.get(index);
    }

//    @GetMapping("tere/{nimi}")
//    public String hello (@PathVariable String nimi) {
//        return "Tere " + nimi;
//    }
//    @GetMapping("korruta/{arv1}/{arv2}")
//    public int multiply (@PathVariable int arv1, @PathVariable int arv2) {
//        return arv1 * arv2;
//    }
}
