package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class championEntityController {
    List<championEntity> stats = new ArrayList<>();

    @GetMapping("stats")
    public List<championEntity> getStats (@PathVariable int stat){
        return stats;
    }
    @PostMapping("stats/{ad}/{hp}/{armor}/{mr}")
    public List<championEntity> addStat (@PathVariable int ad, @PathVariable int hp, @PathVariable int armor, @PathVariable int mr){
        championEntity stat = new championEntity(ad,hp,armor,mr);
        stats.add(stat);
        return stats;
    }
    @DeleteMapping("toidained/{index}")
    public List<championEntity> deleteStat (@PathVariable int index){
        stats.remove(index);
        return stats;
    }
    @PutMapping("stats")
    public List<championEntity> changeStat (
            @RequestParam int index,
            @RequestParam int ad,
            @RequestParam int hp,
            @RequestParam int armor,
            @RequestParam int mr
    ){
        championEntity stat = new championEntity(ad,hp,armor,mr);
        stats.set(index, stat);
        return stats;
    }
}
