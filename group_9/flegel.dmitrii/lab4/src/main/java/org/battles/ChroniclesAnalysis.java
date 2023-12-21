package org.battles;

import org.battles.battle.BattleChronicle;
import org.battles.battle.ChronicleInfo;
import org.battles.json.BattleChronicleDeserializer;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChroniclesAnalysis {
    private static final Logger logger = Logger.getLogger(ChroniclesAnalysis.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Battle statistics calculation started");

        try {
            URI uri = Objects.requireNonNull(Thread.currentThread()
                    .getContextClassLoader().getResource("battle_records.json")).toURI();
            Path path = Paths.get(uri);

            BattleChronicleDeserializer deserializer = new BattleChronicleDeserializer();
            List<BattleChronicle> battleChronicles = deserializer.parseJsonFile(path);

            logger.log(Level.FINE, "Battle records loaded successfully");

            ChronicleInfo chronicleInfo = new ChronicleInfo(battleChronicles);

            String result = chronicleInfo.findMostCasualtiesByEnemyInWinter();
            if (result != null) {
                System.out.println("Khanate with the highest casualties in winter: " + result);
            } else {
                System.out.println("No Khanate found with casualties in winter.");
            }
            System.out.println("Locations with the fewest battles: " +
                    chronicleInfo.findLocationsWithLeastBattles());

            Map<String, List<String>> battlesByEnemy = chronicleInfo.listBattlesByEnemy();
            battlesByEnemy.forEach((enemy, battleList) ->
                    System.out.println("Battles with " + enemy + ": " + battleList));

            logger.log(Level.FINE, "Battle statistics calculated successfully");

        } catch (URISyntaxException e) {
            logger.log(Level.SEVERE, "File battle_records.json not found", e);
            System.out.println("File battle_records.json not found");
        }

        logger.log(Level.INFO, "Battle statistics calculation ended");
    }
}
