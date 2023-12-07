package org.example.json;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.fight.FightResult;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonFightResultsSerializer {
    private final Logger logger = Logger.getLogger(JsonFightResultsSerializer.class.getName());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void serializeFightResults(Collection<FightResult> results, Path path) {
        try {
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(path.toFile(), results);
            logger.log(Level.FINE, path + " written successfully");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException while writing to " + path, e);
            throw new RuntimeException(e);
        }
    }
}
