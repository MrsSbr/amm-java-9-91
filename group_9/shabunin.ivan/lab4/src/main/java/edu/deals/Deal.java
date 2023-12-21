package edu.deals;

import java.time.LocalDate;

public record Deal(String manager, String buyer, double amount, LocalDate date) {
}
