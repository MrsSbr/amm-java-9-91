package data;

import logic.Table;
import logic.PrimaryKey;

import java.math.BigDecimal;

@Table(name = "Студенты")
public record Student(@PrimaryKey int id, String fio, BigDecimal scholarship, int course, int group) {
        }

