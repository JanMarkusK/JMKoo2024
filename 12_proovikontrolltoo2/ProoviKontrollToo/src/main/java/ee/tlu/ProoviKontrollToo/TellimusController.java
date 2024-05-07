package ee.tlu.ProoviKontrollToo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TellimusController {
    @Autowired
    TellimusRepository tellimusRepository;
    @GetMapping("tellimused")
    public List<Tellimus> getTellimused(){
        return tellimusRepository.findAll();
    }
    @PostMapping("tellimused")
    public List<Tellimus> addTellimus(@RequestBody Tellimus tellimus){
        tellimusRepository.save(tellimus);
        return tellimusRepository.findAll();
    }
    @DeleteMapping("tellimuse/{id}")
    public List<Tellimus> deleteTellimus(@PathVariable Long id){
        tellimusRepository.deleteById(id);
        return tellimusRepository.findAll();
    }
}
