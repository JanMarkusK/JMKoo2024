package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduaineEntity;
import ee.tlu.salat.repository.ToiduaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // kontroller ehk front-end saab siit ligi
@RequestMapping("/api") // saab igale API otspunktile eesliidese panna
@CrossOrigin("http://localhost:3000") // see ütleb, mis URL/rakendus mulle ligi pääseb
public class ToiduaineEntityController {
    // localohost:8080/api/toiduained
    @Autowired
    ToiduaineRepository toiduaineRepository;
    //List<ToiduaineEntity> toiduained = new ArrayList<>();

    // Dependency injection
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduaine (){
        return toiduaineRepository.findAll();
    }
    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine (@RequestBody ToiduaineEntity toiduaineEntity){
        if (toiduaineEntity.getValk() + toiduaineEntity.getRasv()+toiduaineEntity.getSysivesik()>100) {
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

    @GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk (@PathVariable int minValk){
        return toiduaineRepository.findAllByValkGreaterThan(minValk);
    }
    @GetMapping("toiduained-sysivesik/{min}/{max}")
    public List<ToiduaineEntity> toiduainedMinValk (@PathVariable int min, @PathVariable int max){
        return toiduaineRepository.findAllBySysivesikBetween(min, max);
    }

}
