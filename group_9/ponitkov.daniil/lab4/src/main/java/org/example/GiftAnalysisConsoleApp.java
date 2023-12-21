package org.example;

import org.example.FileOperations;
import org.example.GiftAnalysisService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GiftAnalysisConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOperations = new FileOperations();
        GiftAnalysisService analysisService = new GiftAnalysisService();

        System.out.println("Enter the filename to read gifts from:");
        String filename = scanner.nextLine();

        try {
            List<Gift> gifts = fileOperations.readGiftsFromFile(filename);

            Set<Integer> years = analysisService.getYears(gifts);
            Map<String, Double> maxWeights = analysisService.getMaxWeights(gifts);
            Map<GiftType, Double> totalWeights = analysisService.getTotalWeights(gifts);

            System.out.println("Years of gifts: " + years);
            System.out.println("Maximum weights by color: " + maxWeights);
            System.out.println("Total weights by type: " + totalWeights);

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}