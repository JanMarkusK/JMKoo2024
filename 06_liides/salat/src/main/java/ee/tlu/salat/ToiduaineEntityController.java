package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToiduaineEntityController {
    // localohost:8080/api/toiduained
    @Autowired
    ToiduaineRepository toiduaineRepository;
    //List<ToiduaineEntity> toiduained = new ArrayList<>();

    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduaine (){
        return toiduaineRepository.findAll();
    }
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesikud}")
    public List<ToiduaineEntity> lisaToiduaine (@RequestBody ToiduaineEntity toiduaineEntity){
        if (toiduaineEntity.valk + toiduaineEntity.rasv+toiduaineEntity.sysivesik>100) {
            return toiduaineRepository.findAll();
        }
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }
    @DeleteMapping("toidained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine (@PathVariable String nimi){
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }
    @PutMapping("toidained")
    public List<ToiduaineEntity> muudaToiduaine (
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesikud
    ){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesikud);
        toiduaineRepository.save(toiduaine); //Täpselt sama mis POST
        // Hibernate kontrollib, kas on juba selline primaarvõtmega element andmebaasis
        return toiduaineRepository.findAll();
    }
    @GetMapping("toiduained/{nimi}")
    public ToiduaineEntity toiduaine (@PathVariable String nimi){
        return toiduaineRepository.findById(nimi).get();
    }
}
