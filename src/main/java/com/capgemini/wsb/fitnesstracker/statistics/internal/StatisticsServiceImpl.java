package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.*;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class StatisticsServiceImpl implements StatisticsProvider, StatisticsService {
    private final StatisticsRepository statisticsRepository;
    private final UserRepository userRepository;
    private final StatisticsMapper statisticsMapper;

    @Override
    public Optional<Statistics> getStatistics(Long statisticsId) {
        return Optional.empty();
    }

    @Override
    public StatisticsResponseDto createStatistics(StatisticsRequestDto dto) {
        Long userId = dto.userId();
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            User user = byId.get();
            Statistics statistics = statisticsMapper.toEntity(dto);
            statistics.setUser(user);
            return statisticsMapper.toDto(statisticsRepository.save(statistics));
        }
        throw new RuntimeException("User not found, can't save statistics.");
    }
}
}
