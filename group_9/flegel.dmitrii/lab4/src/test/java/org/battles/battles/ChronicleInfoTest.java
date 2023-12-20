package org.battles.battles;

import org.battles.battle.BattleChronicle;
import org.battles.battle.ChronicleInfo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChronicleInfoTest {
    @Test
    void findMostCasualtiesByEnemyInWinter() {
        BattleChronicle winterBattle1 = new BattleChronicle(LocalDate.of(2022, 12, 1),
                "Location1", "EnemyA", 50);
        BattleChronicle winterBattle2 = new BattleChronicle(LocalDate.of(2023, 1, 15),
                "Location2", "EnemyB", 30);
        BattleChronicle summerBattle = new BattleChronicle(LocalDate.of(2023, 7, 10),
                "Location3", "EnemyA", 20);

        Collection<BattleChronicle> battleChronicles = Arrays.asList(winterBattle1, winterBattle2, summerBattle);
        ChronicleInfo chronicleInfo = new ChronicleInfo(battleChronicles);

        String mostCasualtiesEnemy = chronicleInfo.findMostCasualtiesByEnemyInWinter();

        assertEquals("EnemyA", mostCasualtiesEnemy);
    }

    @Test
    void findMostCasualtiesByEnemyInWinterEmptyData() {
        ChronicleInfo chronicleInfo = new ChronicleInfo(Collections.emptyList());

        String mostCasualtiesEnemy = chronicleInfo.findMostCasualtiesByEnemyInWinter();

        assertNull(mostCasualtiesEnemy);
    }

    @Test
    void findMostCasualtiesByEnemyInWinterNoWinterBattles() {
        BattleChronicle summerBattle1 = new BattleChronicle(LocalDate.of(2023, 7, 10),
                "Location1", "EnemyA", 20);
        BattleChronicle summerBattle2 = new BattleChronicle(LocalDate.of(2023, 8, 15),
                "Location2", "EnemyB", 30);

        Collection<BattleChronicle> battleChronicles = Arrays.asList(summerBattle1, summerBattle2);
        ChronicleInfo chronicleInfo = new ChronicleInfo(battleChronicles);

        String mostCasualtiesEnemy = chronicleInfo.findMostCasualtiesByEnemyInWinter();

        assertNull(mostCasualtiesEnemy);
    }

    @Test
    void findLocationsWithLeastBattles() {
        BattleChronicle battle1 = new BattleChronicle(LocalDate.of(2022, 12, 1),
                "Location1", "EnemyA", 50);
        BattleChronicle battle2 = new BattleChronicle(LocalDate.of(2023, 1, 15),
                "Location2", "EnemyB", 30);
        BattleChronicle battle3 = new BattleChronicle(LocalDate.of(2023, 1, 20),
                "Location1", "EnemyC", 10);

        Collection<BattleChronicle> battleChronicles = Arrays.asList(battle1, battle2, battle3);
        ChronicleInfo chronicleInfo = new ChronicleInfo(battleChronicles);

        List<String> locationsWithLeastBattles = chronicleInfo.findLocationsWithLeastBattles();

        assertEquals(List.of("Location2"), locationsWithLeastBattles);
    }

    @Test
    void findLocationsWithLeastBattlesEmptyData() {
        ChronicleInfo chronicleInfo = new ChronicleInfo(Collections.emptyList());

        List<String> locationsWithLeastBattles = chronicleInfo.findLocationsWithLeastBattles();

        assertEquals(Collections.emptyList(), locationsWithLeastBattles);
    }

    @Test
    void findLocationsWithLeastBattlesNoBattles() {
        ChronicleInfo chronicleInfo = new ChronicleInfo(Collections.emptyList());

        List<String> locationsWithLeastBattles = chronicleInfo.findLocationsWithLeastBattles();

        assertEquals(Collections.emptyList(), locationsWithLeastBattles);
    }

    @Test
    void listBattlesByEnemy() {
        BattleChronicle battle1 = new BattleChronicle(LocalDate.of(2022, 12, 1),
                "Location1", "EnemyA", 50);
        BattleChronicle battle2 = new BattleChronicle(LocalDate.of(2023, 1, 15),
                "Location2", "EnemyA", 30);
        BattleChronicle battle3 = new BattleChronicle(LocalDate.of(2023, 1, 20),
                "Location1", "EnemyB", 10);

        Collection<BattleChronicle> battleChronicles = Arrays.asList(battle1, battle2, battle3);
        ChronicleInfo chronicleInfo = new ChronicleInfo(battleChronicles);

        Map<String, List<String>> battlesByEnemy = chronicleInfo.listBattlesByEnemy();

        assertEquals(Arrays.asList("Location1", "Location2"), battlesByEnemy.get("EnemyA"));
        assertEquals(List.of("Location1"), battlesByEnemy.get("EnemyB"));
    }

    @Test
    void listBattlesByEnemyEmptyData() {
        ChronicleInfo chronicleInfo = new ChronicleInfo(Collections.emptyList());

        Map<String, List<String>> battlesByEnemy = chronicleInfo.listBattlesByEnemy();

        assertTrue(battlesByEnemy.isEmpty());
    }

    @Test
    void listBattlesByEnemyNoBattles() {
        ChronicleInfo chronicleInfo = new ChronicleInfo(Collections.emptyList());

        Map<String, List<String>> battlesByEnemy = chronicleInfo.listBattlesByEnemy();

        assertTrue(battlesByEnemy.isEmpty());
    }
}
