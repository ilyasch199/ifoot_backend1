package ma.ifootback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ifootback.entities.Pitch;
import ma.ifootback.entities.User;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, Long>{

	@Query("SELECT p FROM Pitch p WHERE p.user =:user")
    public List<Pitch> findBypitchowner(@Param("user") User user);
}
