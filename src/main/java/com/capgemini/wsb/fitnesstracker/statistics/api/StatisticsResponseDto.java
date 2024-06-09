package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.capgemini.wsb.fitnesstracker.user.api.UserSimpleDataDto;

public record StatisticsResponseDto(UserSimpleDataDto user, int totalTrainings, double totalDistance, int totalCaloriesBurned) {
}
