package org.example.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.fight.FightResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonFightResultsDeserializer {
    private final Logger logger = Logger.getLogger(JsonFightResultsDeserializer.class.getName());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<FightResult> parseJsonFile(Path path) {
        File jsonFile = path.toFile();
        try {
            JsonNode jsonArray = objectMapper.readTree(jsonFile);
            List<FightResult> results = new ArrayList<>();
            for (JsonNode node : jsonArray) {
                FightResult result = objectMapper.treeToValue(node, FightResult.class);
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
