package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingRequestDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingServiceImpl trainingService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingResponseDto createTraining(@RequestBody TrainingRequestDto trainingRequestDto) {
        return trainingService.createTraining(trainingRequestDto);
    }
}
