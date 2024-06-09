package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.*;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingServiceImpl implements TrainingProvider, TrainingService{
    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

    @Override
    public Optional<TrainingResponseDto> getTraining(final Long trainingId) {
        Optional<Training> byId = trainingRepository.findById(trainingId);
        return byId.map(trainingMapper::toDto);
    }

    @Override
    public TrainingResponseDto createTraining(TrainingRequestDto training) {
        Optional<User> byId = userRepository.findById(training.userId());
        if(byId.isPresent()) {
            User user = byId.get();
            Training entity = trainingMapper.toEntity(training);
            entity.setUser(user);
            return trainingMapper.toDto(trainingRepository.save(entity));
        }
        throw new RuntimeException("User not found, can't save training.");
    }

}
