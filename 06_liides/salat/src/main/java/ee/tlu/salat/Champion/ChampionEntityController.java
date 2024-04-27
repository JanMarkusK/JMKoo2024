package ee.tlu.salat.Champion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class ChampionEntityController {

    @Autowired
    ChampionEntityRepository championRepository ;
    @GetMapping("stats")
    public List<ChampionEntity> getStats (){
        return championRepository.findAll();
    }

    @PostMapping("stats")
    public List<ChampionEntity> addStat(@RequestBody ChampionEntity championEntity) {

        championRepository.save(championEntity);
        return championRepository.findAll();
    }
    //@PathVariable int ad, @PathVariable int hp, @PathVariable int armor, @PathVariable int mr){
    //        championEntity stat = new championEntity(ad,hp,armor,mr
    @DeleteMapping("stats/{index}")
    public List<ChampionEntity> deleteStat (@PathVariable int index){
        championRepository.deleteById(index);
        return championRepository.findAll();
    }
    @PutMapping("stats/change")
    public List<ChampionEntity> changeStat (
            @RequestParam int index,
            @RequestParam int ad,
            @RequestParam int hp,
            @RequestParam int armor,
            @RequestParam int mr
    ){
        ChampionEntity stat = new ChampionEntity(ad,hp,armor,mr);
        championRepository.save(stat);
        return championRepository.findAll();
    }
}
