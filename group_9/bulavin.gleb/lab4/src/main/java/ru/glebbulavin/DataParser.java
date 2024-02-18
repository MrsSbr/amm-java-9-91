package ru.glebbulavin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataParser {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Collection<SaleRecord> parseFile(String filePath) throws IOException {
        List<SaleRecord> records = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                LocalDate date = LocalDate.parse(parts[0], DATE_FORMAT);
                String dealershipName = parts[1].trim();
                String carName = parts[2].trim();
                String configuration = parts[3].trim();
                BigDecimal markup = new BigDecimal(parts[4].trim());
                records.add(new SaleRecord(date, dealershipName, carName, configuration, markup));
            }
        }
        return records;
    }
}
