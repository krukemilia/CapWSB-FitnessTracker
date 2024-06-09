package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.user.api.UserSimpleDataDto;

public record TrainingResponseDto(UserSimpleDataDto user, double distance, double averageSpeed) {
}
