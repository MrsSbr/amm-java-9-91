package org.example.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.fight.FightResult;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonFightResultsSerializerTest {
    static final List<FightResult> FIGHT_RESULTS = List.of(
            new FightResult(97, LocalDate.of(2003, 8, 13), "Liu Kang", "Smoke", false, true),
            new FightResult(24, LocalDate.of(1992, 3, 1), "Sub-Zero", "Sonya Blade", false, false)
    );

    @Test
    void serializeFightResults() {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("serializer_test", null);
            JsonFightResultsSerializer serializer = new JsonFightResultsSerializer();
            serializer.serializeFightResults(FIGHT_RESULTS, tempFile.toPath());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonArray = mapper.readTree(tempFile);
            List<FightResult> results = new ArrayList<>();

            for (JsonNode node : jsonArray) {
                FightResult result = mapper.treeToValue(node, FightResult.class);
                results.add(result);
            }
            assertEquals(FIGHT_RESULTS, results);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }

    @Test
    void serializeEmptyFightResults() {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("serializer_empty_test", null);
            JsonFightResultsSerializer serializer = new JsonFightResultsSerializer();
            serializer.serializeFightResults(Collections.emptyList(), tempFile.toPath());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonArray = mapper.readTree(tempFile);
            assertTrue(jsonArray.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }
}