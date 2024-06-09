package com.capgemini.wsb.fitnesstracker.training.api;

public interface TrainingService {
    /**
     * Creates new trainings and saves it into database.
     * @param training - DTO of the training data.
     * @return created training DTO.
     */
    TrainingResponseDto createTraining(TrainingRequestDto training);
}
