package org.battles.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.battles.battle.BattleChronicle;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BattleChronicleSerializerTest {
    static final List<BattleChronicle> BATTLE_CHRONICLES = List.of(
            new BattleChronicle(LocalDate.of(2021, 3, 12), "Москва", "Орда", 100),
            new BattleChronicle(LocalDate.of(2021, 6, 3), "Новгород", "Шайтан-Хан", 90)
    );

    @Test
    void serializeBattleChronicles() {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("serializer_test", null);
            BattleChronicleSerializer serializer = new BattleChronicleSerializer();
            serializer.serializeBattleChronicles(BATTLE_CHRONICLES, tempFile.toPath());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonArray = mapper.readTree(tempFile);
            List<BattleChronicle> results = new ArrayList<>();

            for (JsonNode node : jsonArray) {
                BattleChronicle result = mapper.treeToValue(node, BattleChronicle.class);
                results.add(result);
            }
            assertEquals(BATTLE_CHRONICLES, results);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(tempFile != null)
                tempFile.delete();
        }
    }

    @Test
    void serializeEmptyBattleChronicles() {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("serializer_empty_test", null);
            BattleChronicleSerializer serializer = new BattleChronicleSerializer();
            serializer.serializeBattleChronicles(Collections.emptyList(), tempFile.toPath());
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
