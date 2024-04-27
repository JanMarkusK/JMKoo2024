package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduKomponent;
import org.springframework.data.jpa.repository.JpaRepository;

//Teised võimalikud extendid
//extends CrudRepository
//extends SortingAndPagingRepository
public interface ToiduKomponentRepository extends JpaRepository<ToiduKomponent, Long> {
}
