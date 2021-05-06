package bluebottle.racehorsejv8.repository;

import bluebottle.racehorsejv8.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HorseRepository extends JpaRepository<Horse, Long>, HorseRepositoryCustom{

}
