package org.battles.battle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChronicleInfo {
    private final List<BattleChronicle> battleChronicles;

    public ChronicleInfo(Collection<BattleChronicle> battleChronicles) {
        this.battleChronicles = new ArrayList<>(battleChronicles);
    }

    public String findMostCasualtiesByEnemyInWinter() {
        Map<String, Integer> enemyCasualtiesMap = battleChronicles.stream()
                .filter(this::isWinterBattle)
                .collect(Collectors.groupingBy(BattleChronicle::enemy,
                        Collectors.summingInt(BattleChronicle::numberOfKilledBasurman)));

        if (!enemyCasualtiesMap.isEmpty()) {
            return Collections.max(enemyCasualtiesMap.entrySet(), Map.Entry.comparingByValue())
                    .getKey();
        }

        return null;
    }

    public List<String> findLocationsWithLeastBattles() {
        Map<String, Long> locationBattlesCountMap = battleChronicles.stream()
                .collect(Collectors.groupingBy(BattleChronicle::placeOfBattle, Collectors.counting()));

        long minBattles = locationBattlesCountMap.values().stream()
                .min(Long::compare)
                .orElse(0L);

        return locationBattlesCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minBattles)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, List<String>> listBattlesByEnemy() {
        return battleChronicles.stream()
                .collect(Collectors.groupingBy(BattleChronicle::enemy,
                        Collectors.mapping(BattleChronicle::placeOfBattle, Collectors.toList())));
    }

    private boolean isWinterBattle(BattleChronicle battle) {
        int month = battle.date().getMonthValue();
        return month == 12 || month == 1 || month == 2;
    }
}
