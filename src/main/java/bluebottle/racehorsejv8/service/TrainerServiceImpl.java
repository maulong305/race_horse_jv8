package bluebottle.racehorsejv8.service;

import bluebottle.racehorsejv8.model.Trainer;
import bluebottle.racehorsejv8.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainerServiceImpl implements TrainerService{
    @Autowired
    TrainerRepository trainerRepository;
    @Override
    public List<Trainer> findAll(Pageable pageable) {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer findById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    @Override
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Boolean remove(Long id) {
        trainerRepository.deleteById(id);
        return true;
    }
}
