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

    private final List<OlympicStatistic> list;

    public SolverServiceImpl(final List<OlympicStatistic> list) {
        this.list = list;
    }

    @Override
    public List<Country> getTop3BestCountries() {
        return list.stream()
            .filter(SolverServiceImpl::isPrizePlace)
            .collect(
                Collectors.groupingBy(OlympicStatistic::getCountry, Collectors.summingInt(OlympicStatistic::getPlace)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();
    }

    @Override
    public Map<Sport, List<String>> getAthletesBySport() {
        return list.stream()
            .filter(SolverServiceImpl::isPrizePlace)
            .collect(new CollectorBySport((SolverServiceImpl::isPrizePlace)));
    }

    @Override
    public Optional<String> getBestAthlete() {
        return list.stream()
            .filter(SolverServiceImpl::isPrizePlace)
            .collect(Collectors.groupingBy(OlympicStatistic::getAthlete, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey);
    }

    private static boolean isPrizePlace(OlympicStatistic olympicStatistic) {
        return olympicStatistic.getPlace() >= 1 && olympicStatistic.getPlace() <= 3;
    }
}
