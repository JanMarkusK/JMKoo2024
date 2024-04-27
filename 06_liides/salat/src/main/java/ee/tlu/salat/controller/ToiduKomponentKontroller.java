package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduKomponent;
import ee.tlu.salat.repository.ToiduKomponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ToiduKomponentKontroller {

    @Autowired
    ToiduKomponentRepository toiduKomponentRepository;

    //public ToiduKomponentKontroller (ToiduKomponentRepository toiduKomponentRepository) {
    //    this.toiduKomponentRepository = toiduKomponentRepository;
    //}
    @GetMapping("toidukomponendid")
    public List<ToiduKomponent> getToiduKomponents(){
        return toiduKomponentRepository.findAll();
    }
    @DeleteMapping("toidukomponendid/{id}")
    public List<ToiduKomponent> deleteToiduKomponents(@PathVariable Long id){
        toiduKomponentRepository.deleteById(id);
        return toiduKomponentRepository.findAll();
    }
    @PostMapping ("toidukomponendid")
    public List<ToiduKomponent> addToiduKomponents(@RequestBody ToiduKomponent toiduKomponent){
        toiduKomponentRepository.save(toiduKomponent);
        return toiduKomponentRepository.findAll();
    }
}
