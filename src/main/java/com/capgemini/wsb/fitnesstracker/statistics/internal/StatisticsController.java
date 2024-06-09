package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsRequestDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsServiceImpl statisticsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatisticsResponseDto addStatistics(@RequestBody StatisticsRequestDto requestDTO) {
        return statisticsService.createStatistics(requestDTO);
    }
}

