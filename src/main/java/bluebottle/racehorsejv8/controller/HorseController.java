package bluebottle.racehorsejv8.controller;

import bluebottle.racehorsejv8.dto.horser.HorseRequest;
import bluebottle.racehorsejv8.dto.horser.HorseResponse;
import bluebottle.racehorsejv8.dto.horser.UpdateHorseRequest;
import bluebottle.racehorsejv8.model.Horse;
import bluebottle.racehorsejv8.model.Trainer;
import bluebottle.racehorsejv8.service.HorseService;
import bluebottle.racehorsejv8.service.TrainerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/horses/")
public class HorseController {
    @Autowired
    HorseService horseService;

    @Autowired
    TrainerService trainerService;

    private final Date CURRENT_DATE = Calendar.getInstance().getTime();

    @GetMapping
    public ResponseEntity<List<HorseResponse>> getAll(@RequestParam(name = "pageIndex", required = false)
                                                              Integer pageIndex,
                                                      @RequestParam(name = "pageSize", required = false)
                                                              Integer pageSize) {
        pageSize = pageSize != null ? pageSize : 5;
        pageIndex = pageIndex != null ? pageIndex : 0;
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        List<Horse> horses = horseService.findAll(pageable);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (horses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            for (Horse horse : horses) {
                HorseResponse horseResponse = new HorseResponse(horse);
                horseResponseList.add(horseResponse);
            }
            return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
        }
    }

    @PostMapping("create")
    public ResponseEntity<Horse> create(@RequestBody HorseRequest horseRequest) {
        Horse horse = new Horse();
        BeanUtils.copyProperties(horseRequest, horse);
        horse.setFoaled(CURRENT_DATE);
        horseService.save(horse);
        return new ResponseEntity<>(horse, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<HorseResponse> edit(@RequestBody UpdateHorseRequest updateHorseRequest) {
        HorseResponse horseResponse = horseService.update(updateHorseRequest);
        return new ResponseEntity<>(horseResponse, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        Horse horse = horseService.findById(id);
        if (horse == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        horseService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAllByTrainerId")
    public ResponseEntity<List<HorseResponse>> getAllByTrainerId(@RequestParam("trainerId") Long id) {
        Trainer trainer = trainerService.findById(id);
        List<Horse> horses = horseService.findAllByTrainer(id);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (trainer == null || horses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            for (Horse horse : horses) {
                HorseResponse horseResponse = new HorseResponse(horse);
                horseResponseList.add(horseResponse);
            }
            return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
        }
    }

    @GetMapping("getAllByTrainerIdAndName")
    public ResponseEntity<List<HorseResponse>> getAllByTrainerIdAndName(@RequestParam("trainerId") Long id,
                                                                        @RequestParam("horseName") String horseName,
                                                                        @RequestParam Integer pageIndex,
                                                                        @RequestParam Integer pageSize) {
        Trainer trainer = trainerService.findById(id);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        List<Horse> horses = horseService.findAllByTrainerAndName(id, horseName, pageable);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (trainer == null || horses == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        for (Horse horse : horses) {
            HorseResponse horseResponse = new HorseResponse(horse);
            horseResponseList.add(horseResponse);
        }
        return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
    }

}
