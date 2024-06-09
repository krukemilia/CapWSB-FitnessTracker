package com.capgemini.wsb.fitnesstracker.statistics.api;

public record StatisticsRequestDto(Long userId, int totalTrainings, double totalDistance, int totalCaloriesBurned) {
}
