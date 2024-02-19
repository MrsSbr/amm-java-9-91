package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {

    public static void writeResultsToFile(String fileName, String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(result);
            System.out.println("Results written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing results to file: " + e.getMessage());
        }
    }
}