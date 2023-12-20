package org.battles.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.battles.battle.BattleChronicle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleChronicleDeserializer {
    private final Logger logger = Logger.getLogger(BattleChronicleDeserializer.class.getName());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<BattleChronicle> parseJsonFile(Path path) {
        File jsonFile = path.toFile();
        try {
            JsonNode jsonArray = objectMapper.readTree(jsonFile);
            List<BattleChronicle> results = new ArrayList<>();
            for (JsonNode node : jsonArray) {
                BattleChronicle result = objectMapper.treeToValue(node, BattleChronicle.class);
                logger.log(Level.FINE, result.toString() + " read");
                results.add(result);
            }
            logger.log(Level.FINE, path + " parsed successfully");
            return results;

        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException while reading " + path, e);
            throw new RuntimeException(e);
        }
    }
}
