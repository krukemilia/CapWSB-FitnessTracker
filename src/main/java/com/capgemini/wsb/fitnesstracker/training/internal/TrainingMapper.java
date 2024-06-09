package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingRequestDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingResponseDto;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserSimpleDataDto;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {
    public TrainingResponseDto toDto(Training training) {
        User user = training.getUser();
        UserSimpleDataDto userSimpleDataDto = new UserSimpleDataDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return new TrainingResponseDto(userSimpleDataDto, training.getDistance(), training.getAverageSpeed());
    }

    public Training toEntity(TrainingRequestDto trainingRequestDto) {
        Training training = new Training();
        training.setStartTime(trainingRequestDto.startTime());
        training.setEndTime(trainingRequestDto.endTime());
        training.setDistance(trainingRequestDto.distance());
        training.setActivityType(trainingRequestDto.activityType());
        training.setAverageSpeed(trainingRequestDto.averageSpeed());
        return training;
    }

}
