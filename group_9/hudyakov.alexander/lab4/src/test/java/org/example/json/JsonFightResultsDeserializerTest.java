package org.example.json;

import org.example.fight.FightResult;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonFightResultsDeserializerTest {
    static final List<FightResult> FIGHT_RESULTS = List.of(
            new FightResult(97, LocalDate.of(2003, 8, 13), "Liu Kang", "Smoke", false, true),
            new FightResult(24, LocalDate.of(1992, 3, 1), "Sub-Zero", "Sonya Blade", false, false)
    );

    @Test
    void parseJsonFile() throws URISyntaxException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource("json/FightResultsTest.json").toURI();
        Path path = Paths.get(uri);
        JsonFightResultsDeserializer deserializer = new JsonFightResultsDeserializer();
        List<FightResult> results = deserializer.parseJsonFile(path);
        assertEquals(FIGHT_RESULTS.size(), results.size());
        assertEquals(FIGHT_RESULTS, results);
    }

    @Test
    void parseEmptyJsonFile() throws URISyntaxException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource("json/Empty.json").toURI();
        Path path = Paths.get(uri);
        JsonFightResultsDeserializer deserializer = new JsonFightResultsDeserializer();
        List<FightResult> results = deserializer.parseJsonFile(path);
        assertTrue(results.isEmpty());
    }
}