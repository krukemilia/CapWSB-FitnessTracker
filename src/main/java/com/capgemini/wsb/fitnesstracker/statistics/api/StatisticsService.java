package com.capgemini.wsb.fitnesstracker.statistics.api;

public interface StatisticsService {

    /**
     * Creates new statistics.
     * @param dto - data including userId
     * @return statisticsDTO including the data about the user.
     */
    StatisticsResponseDto createStatistics(StatisticsRequestDto dto);
}

