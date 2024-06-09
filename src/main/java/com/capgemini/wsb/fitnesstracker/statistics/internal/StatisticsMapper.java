package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsRequestDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsResponseDto;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserSimpleDataDto;
import org.springframework.stereotype.Component;

@Component
public class StatisticsMapper {

    StatisticsResponseDto toDto(Statistics statistics) {
        User user = statistics.getUser();
        UserSimpleDataDto simpleDataDto = new UserSimpleDataDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return new StatisticsResponseDto(simpleDataDto, statistics.getTotalTrainings(), statistics.getTotalDistance(), statistics.getTotalCaloriesBurned());
    }

    Statistics toEntity(StatisticsRequestDto dto) {
        Statistics statistics = new Statistics();
        statistics.setTotalDistance(dto.totalDistance());
        statistics.setTotalTrainings(dto.totalTrainings());
        statistics.setTotalCaloriesBurned(dto.totalCaloriesBurned());
        return statistics;
    }
}
