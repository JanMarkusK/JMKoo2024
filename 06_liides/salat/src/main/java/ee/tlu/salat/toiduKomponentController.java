package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class toiduKomponentController {
    List<toiduKomponent> toidukomponendid = new ArrayList<>();

    @PostMapping ("toidukomponent")
    public  List<toiduKomponent> LisaToidukomponent (@RequestBody toiduKomponent komponent){
        toidukomponendid.add(komponent);
        return toidukomponendid;
    }
    @PutMapping ("toidukomponent/{index}")
    public  List<toiduKomponent> MuudaToidukomponent (@PathVariable int index, @RequestBody toiduKomponent komponent){
        toidukomponendid.set(index, komponent);
        return toidukomponendid;
    }
}
