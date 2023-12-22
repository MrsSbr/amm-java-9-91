package org.example;

import org.example.Gift;
import org.example.GiftSize;
import org.example.GiftType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public List<Gift> readGiftsFromFile(String filename) throws IOException {
        List<Gift> gifts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                gifts.add(new Gift(
                        Integer.parseInt(parts[0]),
                        GiftSize.valueOf(parts[1]),
                        Double.parseDouble(parts[2]),
                        GiftType.valueOf(parts[3]),
                        parts[4]));
            }
        }
        return gifts;
    }

    public void writeGiftsToFile(List<Gift> gifts, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Gift gift : gifts) {
                writer.write(gift.toString() + "\n");
            }
        }
    }
}