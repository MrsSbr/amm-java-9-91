package service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import entity.Country;
import entity.OlympicStatistic;
import entity.Sport;
import service.collector.CollectorBySport;


public class SolverServiceImpl implements SolverService {

    @Override
    public List<Country> getTop3BestCountries(final List<OlympicStatistic> list) {
        if (list == null) {
            throw new IllegalArgumentException("the list cannot be null");
        }

        return list.stream()
            .filter(SolverServiceImpl::isPrizePlace)
            .collect(
                Collectors.groupingBy(OlympicStatistic::country, Collectors.summingInt(OlympicStatistic::place)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();
    }

    @Override
    public Map<Sport, List<String>> getAthletesBySport(final List<OlympicStatistic> list) {
        if (list == null) {
            throw new IllegalArgumentException("the list cannot be null");
        }
        return list.stream()
            .filter(SolverServiceImpl::isPrizePlace)
            .collect(new CollectorBySport((SolverServiceImpl::isPrizePlace)));
    }

    @Override
    public Optional<String> getBestAthlete(final List<OlympicStatistic> list) {
        if (list == null) {
            throw new IllegalArgumentException("the list cannot be null");
        }
        return list.stream()
            .filter(SolverServiceImpl::isPrizePlace)
            .collect(Collectors.groupingBy(OlympicStatistic::athlete, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey);
    }

    private static boolean isPrizePlace(OlympicStatistic olympicStatistic) {
        return olympicStatistic.place() >= 1 && olympicStatistic.place() <= 3;
    }
}
