package org.battles.json;

import org.battles.battle.BattleChronicle;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BattleChronicleDeserializerTest {
    static final List<BattleChronicle> BATTLE_CHRONICLES = List.of(
            new BattleChronicle(LocalDate.of(2021, 3, 12), "Москва", "Орда", 100),
            new BattleChronicle(LocalDate.of(2021, 6, 3), "Новгород", "Шайтан-Хан", 90)
    );
    private static final String TEST_JSON_RESOURCE = "deserializer_test.json";
    private static final String EMPTY_JSON_RESOURCE = "empty.json";

    @Test
    void parseJsonFile() throws URISyntaxException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource(TEST_JSON_RESOURCE).toURI();
        Path path = Paths.get(uri);
        BattleChronicleDeserializer deserializer = new BattleChronicleDeserializer();
        List<BattleChronicle> results = deserializer.parseJsonFile(path);
        assertEquals(BATTLE_CHRONICLES.size(), results.size());
        assertEquals(BATTLE_CHRONICLES, results);
    }

    @Test
    void parseEmptyJsonFile() throws URISyntaxException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource(EMPTY_JSON_RESOURCE).toURI();
        Path path = Paths.get(uri);
        BattleChronicleDeserializer deserializer = new BattleChronicleDeserializer();
        List<BattleChronicle> results = deserializer.parseJsonFile(path);
        assertTrue(results.isEmpty());
    }
}
