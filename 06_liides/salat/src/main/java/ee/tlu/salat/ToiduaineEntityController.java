package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToiduaineEntityController {
    // localohost:8080/api/toiduained
    List<ToiduaineEntity> toiduained = new ArrayList<>();
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduaine (@PathVariable String toiduaine){
        return toiduained;
    }
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesikud}")
    public List<ToiduaineEntity> lisaToiduaine (@PathVariable String nimi, @PathVariable int valk, @PathVariable int rasv, @PathVariable int sysivesikud){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesikud);
        toiduained.add(toiduaine);
        return toiduained;
    }
    @DeleteMapping("toidained/{index}")
    public List<ToiduaineEntity> kustutaToiduaine (@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }
    @PutMapping("toidained")
    public List<ToiduaineEntity> muudaToiduaine (
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesikud
    ){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesikud);
        toiduained.set(index, toiduaine);
        return toiduained;
    }
    @GetMapping("toiduained/{index}")
    public ToiduaineEntity toiduaine (@PathVariable int index){
        return toiduained.get(index);
    }
}
