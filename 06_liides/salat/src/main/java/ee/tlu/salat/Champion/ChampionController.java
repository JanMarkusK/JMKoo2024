package ee.tlu.salat.Champion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ChampionController {

    @Autowired
    ChampionRepository championRepository;

    @GetMapping("champions")
    public List<Champion> getChampions(){
        return championRepository.findAll();
    }
    @DeleteMapping("champions/{id}")
    public List<Champion> deleteChampions(@PathVariable Long id){
        championRepository.deleteById(id);
        return championRepository.findAll();
    }
    @PostMapping ("champions")
    public List<Champion> addChampions(@RequestBody Champion champion){
        championRepository.save(champion);
        return championRepository.findAll();
    }
}

