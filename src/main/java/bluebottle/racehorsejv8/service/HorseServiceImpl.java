package bluebottle.racehorsejv8.service;

import bluebottle.racehorsejv8.dto.horser.HorseResponse;
import bluebottle.racehorsejv8.dto.horser.UpdateHorseRequest;
import bluebottle.racehorsejv8.model.Horse;
import bluebottle.racehorsejv8.repository.HorseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HorseServiceImpl implements HorseService{
    @Autowired
    HorseRepository horseRepository;
    @Override
    public List<Horse> findAll(Pageable pageable) {
        return horseRepository.findAll();
    }

    @Override
    public Horse findById(Long id) {
        return horseRepository.findById(id).orElse(null);
    }

    @Override
    public Horse save(Horse horse) {
        return horseRepository.save(horse);
    }

    @Override
    public Boolean remove(Long id) {
        horseRepository.deleteById(id);
        return true;
    }

    @Override
    public HorseResponse update(UpdateHorseRequest request) {
        Horse horse = horseRepository.findById(request.getId()).orElse(null);
        if (horse == null){
            return null;
        }else {
            BeanUtils.copyProperties(request, horse);
            horseRepository.save(horse);
            return new HorseResponse(horse);
        }
    }

    @Override
    public List<Horse> findAllByTrainer(Long id) {
        return horseRepository.findAllByTrainerId(id);
    }
}
