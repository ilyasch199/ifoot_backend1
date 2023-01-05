package ma.ifootback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ifootback.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
