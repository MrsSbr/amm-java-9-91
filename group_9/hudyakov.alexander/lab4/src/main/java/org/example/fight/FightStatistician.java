package org.example.fight;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FightStatistician {
    private final Collection<FightResult> fightResults;

    public FightStatistician(Collection<FightResult> fightResults) {
        this.fightResults = new ArrayList<>(fightResults);
    }

    public Collection<Month> getMonthsWithMostFatalitiesCountOverPastThreeYears() {
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
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getFightersVictoryCount() {
        return fightResults.stream()
                .collect(Collectors.toMap(x -> x.firstWon() ? x.firstFighter() : x.secondFighter(), x -> 1, Integer::sum));
    }

    public Map<Integer, Collection<String>> getTournamentsFighters() {
        return fightResults.stream()
                .collect(Collectors.groupingBy(FightResult::tournamentNumber))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .flatMap(x -> Stream.of(x.firstFighter(), x.secondFighter()))
                                .collect(Collectors.toSet()),
                        (e, r) -> {
                            e.addAll(r);
                            return e;
                        })
                );
    }
}
