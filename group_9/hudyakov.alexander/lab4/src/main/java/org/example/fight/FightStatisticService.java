package org.example.fight;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FightStatisticService {
    Set<Month> getMonthsWithMostFatalitiesCountOverPastThreeYears(List<FightResult> fightResults);

    Map<String, Integer> getFightersVictoryCount(List<FightResult> fightResults);

    Map<Integer, Set<String>> getTournamentsFighters(List<FightResult> fightResults);
}
