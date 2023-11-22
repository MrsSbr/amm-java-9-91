package org.example;

import org.example.fight.FightResult;
import org.example.fight.FightStatistician;
import org.example.json.JsonFightResultsDeserializer;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SummarizingStatistics {
    private static final Logger logger = Logger.getLogger(SummarizingStatistics.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Summarizing started");
        try {
            URI uri = Thread.currentThread().getContextClassLoader().getResource("results.json").toURI();
            Path path = Paths.get(uri);
            JsonFightResultsDeserializer deserializer = new JsonFightResultsDeserializer();
            List<FightResult> results = deserializer.parseJsonFile(path);

            logger.log(Level.FINE, "File read successfully");

            FightStatistician statistician = new FightStatistician(results);

            System.out.print("Fighters victories count: ");
            System.out.println(statistician.getFightersVictoryCount());
            System.out.print("Tournaments fighters: ");
            System.out.println(statistician.getTournamentsFighters());
            System.out.print("Months with most fatalities count over past three years: ");
            System.out.println(statistician.getMonthsWithMostFatalitiesCountOverPastThreeYears());

            logger.log(Level.FINE, "Statistics summarized successfully");

        } catch (URISyntaxException e) {
            logger.log(Level.SEVERE, "File results.json not found", e);
            System.out.println("File results.json not found");
        }
        logger.log(Level.INFO, "Summarizing ended");
    }
}