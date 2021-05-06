package bluebottle.racehorsejv8.service;

import bluebottle.racehorsejv8.dto.horser.HorseResponse;
import bluebottle.racehorsejv8.dto.horser.UpdateHorseRequest;
import bluebottle.racehorsejv8.model.Horse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HorseService extends IService<Horse>{
    HorseResponse update(UpdateHorseRequest request);
    List<Horse> findAllByTrainer(Long id);
    List<Horse> findAllByTrainerAndName(Long id, String name, Pageable pageable);
    List<Horse> findAllByFoaled(Long id, String year, Pageable pageable);
}
