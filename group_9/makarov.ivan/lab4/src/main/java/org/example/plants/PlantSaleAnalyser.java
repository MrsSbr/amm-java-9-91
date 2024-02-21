package org.example.plants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class PlantSaleAnalyser {

    public static void main(String[] args) {
        try {
            Path path = Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                    .getResource("plants.txt")).toURI());
            List<PlantSaleEntry> statistics = PlantSaleEntryReader.read(path);

            System.out.println("Most popular type of plant: " +
                    PlantShopAnalyzer.findMostBloomingMonth(statistics));

            System.out.println("Plant with the highest growth rate: " +
                    PlantShopAnalyzer.findLeastProfitablePlant(statistics));

            System.out.println("Plants with matching characteristics as the most common plant: " +
                    PlantShopAnalyzer.findPotSizesForPlants(statistics));
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
