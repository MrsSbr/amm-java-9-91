package org.example.fight;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FightStatistician {
    private final List<FightResult> fightResults;

    public FightStatistician(Collection<FightResult> fightResults) {
        this.fightResults = new ArrayList<>(fightResults);
    }

    public Set<Month> getMonthsWithMostFatalitiesCountOverPastThreeYears() {
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

    public Map<String, Integer> getFightersVictoryCount() {
        return fightResults.stream()
                .collect(Collectors.toMap(x -> x.firstWon() ? x.firstFighter() : x.secondFighter(), x -> 1, Integer::sum));
    }

    public Map<Integer, Set<String>> getTournamentsFighters() {
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
