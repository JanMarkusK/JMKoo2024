package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface PoodRepository extends JpaRepository<Pood, Long> {

    List<Pood> findByAvamisAegGreaterThanAndSulgemisAegLessThan(int avamisAeg, int sulgemisAeg);
    Pood findByNimetus(String nimetus);
    Pood findFirstByOrderByKulastunuteArvDesc();
}
