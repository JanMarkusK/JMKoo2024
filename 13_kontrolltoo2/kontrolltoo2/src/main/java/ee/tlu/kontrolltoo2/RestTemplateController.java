package ee.tlu.kontrolltoo2;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestTemplateController {

    @GetMapping("tootajad")
    public List<String> getTootajadEmails() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Tootaja[]> response = restTemplate.exchange("https://reqres.in/api/users?page=2", HttpMethod.GET, null, Tootaja[].class);

        return Arrays.stream(response.getBody())
                .map(Tootaja::getEmail)
                .collect(Collectors.toList());
    }
    @GetMapping("suurima-hinnaga-toode")
    public Toode getSuurimaHinnagaToode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Toode[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET, null, Toode[].class);
        Toode sHinnagaToode = null;
        int suurim = 0;
        for (Toode t : response.getBody()){
            if(suurim < t.price){
                suurim = t.price;
                sHinnagaToode = t;
            }
        }
        return sHinnagaToode;
    }
    @GetMapping("vaikseima-hinnaga-toode")
    public Toode getVaikseimaHinnagaToode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Toode[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET, null, Toode[].class);
        Toode vHinnagaToode = null;
        int vaikseim = 1000;
        for (Toode t : response.getBody()){
            if(t.price < vaikseim){
                vaikseim = t.price;
                vHinnagaToode = t;
            }
        }
        return vHinnagaToode;
    }
    @GetMapping("vaikseim-kui-antud-hinnaga-tooted/{number}")
    public List<Toode> getVaikseimKuiAntudHinnagaToode(@PathVariable int number) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Toode[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET, null, Toode[].class);
        List<Toode> vHinnagaTooted = new ArrayList<>();
        for (Toode t : response.getBody()){
            if(t.price < number){
                vHinnagaTooted.add(t);
            }
        }
        return vHinnagaTooted;
    }
    @GetMapping("suurem-kui-antud-hinnaga-tooted/{number}")
    public List<Toode> getSuuremKuiAntudHinnagaToode(@PathVariable int number) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Toode[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET, null, Toode[].class);
        List<Toode> sHinnagaTooted = new ArrayList<>();
        for (Toode t : response.getBody()){
            if(t.price > number){
                sHinnagaTooted.add(t);
            }
        }
        return sHinnagaTooted;
    }
    @GetMapping("vahemikus-hinnaga-tooted/{min}/{max}")
    public List<Toode> getSuuremKuiAntudHinnagaToode(@PathVariable int min ,@PathVariable int max) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Toode[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET, null, Toode[].class);
        List<Toode> vahemikusHinnagaTooted = new ArrayList<>();
        for (Toode t : response.getBody()){
            if(t.price > min && t.price < max ){
                vahemikusHinnagaTooted.add(t);
            }
        }
        return vahemikusHinnagaTooted;
    }
}
