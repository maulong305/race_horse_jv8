package bluebottle.racehorsejv8.repository;

import bluebottle.racehorsejv8.model.Horse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseRepositoryCustom {
    List<Horse> findAllByTrainerId(Long id);
}
