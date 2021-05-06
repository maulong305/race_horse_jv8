package bluebottle.racehorsejv8.repository;

import bluebottle.racehorsejv8.model.Horse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseRepositoryCustom {
    List<Horse> findAllByTrainerId(Long id);
    List<Horse> findAllByTrainerIdAndHorseName(Long id, String name, Pageable pageable);
    List<Horse> findAllByFoaled(Long id, String year, Pageable pageable);
}
