package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PoodController {

    @Autowired
    PoodRepository poodRepository;
    
    @GetMapping("Pood")
    public List<Pood> getPood(){
        return poodRepository.findAll();
    }
    @PostMapping("Pood")
    public List<Pood> addPood(@RequestBody Pood Pood){
        poodRepository.save(Pood);
        return poodRepository.findAll();
    }
    @DeleteMapping("Pood/{id}")
    public List<Pood> deletePood(@PathVariable Long id){
        poodRepository.deleteById(id);
        return poodRepository.findAll();
    }
    @GetMapping("Pood/{kell}")
    public List<Pood> getPoodByTime(@PathVariable int kell){
        return poodRepository.findByAvamisAegGreaterThanAndSulgemisAegLessThan(kell, kell);
    }
    @GetMapping("pood/{nimetus}")
    public Pood getPoodByNimi(@PathVariable String nimetus) {
        Pood pood = (Pood) poodRepository.findByNimetus(nimetus);
        if (pood != null) {

            pood.setKulastunuteArv(pood.getKulastunuteArv() + 1);
            poodRepository.save(pood);
        }
        return poodRepository.findByNimetus(nimetus);
    }
    @GetMapping("Pood-suurim-kulastajate-arvuga")
    public Pood getPoodByHighestKulastajad(){
        return poodRepository.findFirstByOrderByKulastunuteArvDesc();
    }
}
