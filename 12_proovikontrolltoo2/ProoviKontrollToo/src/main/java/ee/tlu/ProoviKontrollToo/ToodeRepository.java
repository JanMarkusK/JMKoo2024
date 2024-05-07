package ee.tlu.ProoviKontrollToo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<Toode, Long> {

    // nende päringute leidmisel kasuta JPABuddy't paremal ääres ;)
    List<Toode> findByHindBetween(double hindStart, double hindEnd);
    List<Toode> findFirstByHindNotNUllOrderByHindDesc();
    List<Toode> findByNimiContains(String nimi);
    List<Toode> findByNimiStartsWith(String nimi);
    List<Toode> findByKategooria_id(Long id);
}
