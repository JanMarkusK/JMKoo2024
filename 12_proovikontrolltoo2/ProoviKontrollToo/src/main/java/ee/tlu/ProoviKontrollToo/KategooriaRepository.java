package ee.tlu.ProoviKontrollToo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KategooriaRepository extends JpaRepository<Kategooria, Long> {// Kirjuta siin long suuretähega(Long) kuna see näitab ka klassi


}