package org.bouquets.order;

public enum BouquetType {
    WEDDING("Свадебный"),
    JUBILEE("Юбилейный"),
    NEW_YEAR("Новогодний"),
    BUSINESS("Деловой"),
    ROMANTIC("Романтический"),
    BOX("В коробке");
    private final String type;
    BouquetType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
