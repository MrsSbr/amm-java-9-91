package org.bouquets.order;

public enum ReceivingType {
    DELIVERY("Доставка"),
    MANUALLY("Самовывоз");
    private final String type;
    ReceivingType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
