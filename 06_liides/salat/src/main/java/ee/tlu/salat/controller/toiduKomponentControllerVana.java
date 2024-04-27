package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduKomponent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class toiduKomponentControllerVana {
    List<ToiduKomponent> toidukomponendid = new ArrayList<>();

    @PostMapping ("toidukomponent")
    public  List<ToiduKomponent> LisaToidukomponent (@RequestBody ToiduKomponent komponent){
        toidukomponendid.add(komponent);
        return toidukomponendid;
    }
    @PutMapping ("toidukomponent/{index}")
    public  List<ToiduKomponent> MuudaToidukomponent (@PathVariable int index, @RequestBody ToiduKomponent komponent){
        toidukomponendid.set(index, komponent);
        return toidukomponendid;
    }
}
