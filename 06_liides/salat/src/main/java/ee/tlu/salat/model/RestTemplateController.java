package ee.tlu.salat.model;

import ee.tlu.salat.model.Omniva;
import ee.tlu.salat.model.Post;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController // kontroller ehk front-end saab siit ligi
@CrossOrigin("http://localhost:3000") // see ütleb, mis URL/rakendus mulle ligi pääseb
public class RestTemplateController {

    @GetMapping("saa-postitused")
    public List<Post> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        //1. aadress kuhu 2. meetod mida teeme (meie teeme alatai GET) 3. mida kaasa saadan (body, hearid)
        ResponseEntity<Post[]> response= restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);
        return List.of(response.getBody());
    }
    @GetMapping("saa-postitused/{kasutajaId}")
    public List<Post> getUserPosts(@PathVariable int kasutajaid) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response= restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);

        List<Post> kasutajaPostitused = new ArrayList<>();
        for (Post p :response.getBody()){
            if (p.getUserId()==kasutajaid){
                kasutajaPostitused.add(p);
            }
        }
        return kasutajaPostitused;
    }
    @GetMapping("omniva")
    public List<Omniva> getOmnivaPMs(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response= restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);
        return List.of(response.getBody());
    }
    @GetMapping("omniva/{country}")
    public List<Omniva> getOmnivaPMsByCountry(@PathVariable String country){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response= restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);

        List<Omniva> omnivaPakiautomaadid = new ArrayList<>();
        for (Omniva o :response.getBody()){
            if (o.getA0_NAME().equals(country)){ //pead panema. equals, kui võrdled teksti javas
                omnivaPakiautomaadid.add(o);
            }
        }
        return omnivaPakiautomaadid;
    }

    @GetMapping("saa-nordpool-hinnad")
    public ee.tlu.salat.model.Nordpool getNordpooliHinnad() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<ee.tlu.salat.model.Nordpool> response= restTemplate.exchange(url, HttpMethod.GET, null, ee.tlu.salat.model.Nordpool.class);
        return response.getBody();
    }
    @GetMapping("saa-nordpool-hinnad/{country}")
    public List<ee.tlu.salat.model.TimestampPrice> getNordpooliHinnad(@PathVariable String country) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<ee.tlu.salat.model.Nordpool> response= restTemplate.exchange(url, HttpMethod.GET, null, ee.tlu.salat.model.Nordpool.class);

        return ee.tlu.salat.model.TimestampPrice;
    }


}
