package bluebottle.racehorsejv8.repository;

import bluebottle.racehorsejv8.model.Horse;

import java.util.List;

public interface HorseRepositoryCustom {
    List<Horse> findAllByTrainerId(Long id);
}
