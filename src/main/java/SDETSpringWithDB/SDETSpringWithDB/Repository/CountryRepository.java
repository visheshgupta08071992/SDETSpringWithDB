package SDETSpringWithDB.SDETSpringWithDB.Repository;

import SDETSpringWithDB.SDETSpringWithDB.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CountryRepository  extends JpaRepository<Country,Integer> {
}
