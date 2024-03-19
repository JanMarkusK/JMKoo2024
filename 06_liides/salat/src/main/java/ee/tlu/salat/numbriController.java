package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class numbriController {
    List<Integer> numbrid = new ArrayList<>();

    @GetMapping("numbrid")
    public List<Integer> saaNumber (){
        return numbrid;
    }
    @PostMapping("numbrid/{number}")
    public List<Integer> lisaNumber (@PathVariable int number){
        numbrid.add(number);
        return numbrid;
    }
    @DeleteMapping("numbrid/{index}")
    public List<Integer> kustutaNumber (@PathVariable int index){
        numbrid.remove(index);
        return numbrid;
    }
    @GetMapping("numbrid/hulk")
    public int saaNumbriHulk (){
        int numbriteHulk = numbrid.size();
        return numbriteHulk;
    }
    @GetMapping("numbrid/summa")
    public int saaNumbriteSumma (){
        int summa = 0;
        for (int i = 0; i < numbrid.size(); i++) {
            summa += numbrid.get(i); // Lisan iga numbri summale juurde
        }
        return summa;
    }
    @GetMapping("numbrid/keskmine")
    public float saaNumbriteKesk (){
        int summa = 0;
        for (int i = 0; i < numbrid.size(); i++) {
            summa += numbrid.get(i); // Lisan iga numbri summale juurde
        }
        float kesk = summa / numbrid.size(); // Leian aritmeetilise keskmise
        return kesk;
    }
}
