package ee.tlu.ProoviKontrollToo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class KategooriaController {

    @Autowired
    KategooriaRepository KategooriaRepository; // <- saame andmebaasi funktsione teha
    @Autowired
    ToodeRepository toodeRepository;
    @GetMapping("kategooriad")
    public List<Kategooria> getKategooriad(){
        return KategooriaRepository.findAll();
    }
    @PostMapping("kategooriad")
    public List<Kategooria> addKategooria(@RequestBody Kategooria Kategooria){
        KategooriaRepository.save(Kategooria);
        return KategooriaRepository.findAll();
    }
    @DeleteMapping("kategooria/{id}")
    public List<Kategooria> deleteKategooria(@PathVariable Long id){
        KategooriaRepository.deleteById(id);
        return KategooriaRepository.findAll();
    }
    @GetMapping("kategooria-tooted/{id}")
    public List<Toode> getKategooriadById(@PathVariable Long id){
        return toodeRepository.findByKategooria_id(id);
    }
    @GetMapping("kategooria-tooted-kokku/{id}")
    public double sumKategooriaTooted(@PathVariable Long id){
        double sum = 0;
        for(Toode t: toodeRepository.findByKategooria_id(id)){
            sum += t.getHind();
        }
        return sum;
        //Teine võimalus sama asja tegemiseks (parem)
        //return toodeRepository.findByKategooria_id(id).stream().mapToDouble(e -> e.getHind()).sum();
    }
}
