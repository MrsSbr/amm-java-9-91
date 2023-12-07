package org.example.fight;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FightStatisticServiceImpl implements FightStatisticService {

    @Override
    public Set<Month> getMonthsWithMostFatalitiesCountOverPastThreeYears(List<FightResult> fightResults) {
        LocalDate minimumDate = LocalDate.now().minusYears(3);

        Map<Month, Integer> monthMap = fightResults.stream()
                .filter(x -> x.date().isAfter(minimumDate))
                .filter(FightResult::fatalityCommitted)
                .collect(Collectors.toMap(x -> x.date().getMonth(),
                        x -> 1,
                        Integer::sum));
        Integer max = monthMap.values().stream().max(Integer::compareTo).orElse(0);

        return monthMap.entrySet().stream()
                .filter(x -> x.getValue().equals(max))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> getFightersVictoryCount(List<FightResult> fightResults) {
        return fightResults.stream()
                .collect(Collectors.toMap(x -> x.firstWon() ? x.firstFighter() : x.secondFighter(), x -> 1, Integer::sum));
    }

    @Override
    public Map<Integer, Set<String>> getTournamentsFighters(List<FightResult> fightResults) {
        return fightResults.stream()
                .collect(Collectors.groupingBy(FightResult::tournamentNumber))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        numberFightResultPair -> numberFightResultPair.getValue().stream()
                                .flatMap(x -> Stream.of(x.firstFighter(), x.secondFighter()))
                                .collect(Collectors.toSet()),
                        (existingFighters, newFighters) -> {
                            existingFighters.addAll(newFighters);
                            return existingFighters;
                        })
                );
    }
}
