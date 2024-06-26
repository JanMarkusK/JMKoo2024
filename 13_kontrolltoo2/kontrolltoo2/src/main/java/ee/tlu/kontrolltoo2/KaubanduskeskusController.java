package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KaubanduskeskusController {

    @Autowired
    KaubanduskeskusRepository kaubanduskeskusRepository;

    @GetMapping("KaubandusePoed")
    public List<Kaubanduskeskus> getKKPoed(){

        return kaubanduskeskusRepository.findAll();
    }
}
