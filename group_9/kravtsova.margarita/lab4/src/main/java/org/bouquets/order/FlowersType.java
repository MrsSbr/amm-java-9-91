package org.bouquets.order;

public enum FlowersType {
    ROSE("Роза"),
    TULIP("Тюльпан"),
    CHRYSANTHEMUM("Хризантема"),
    ASTER("Астра"),
    IRIS("Ирис"),
    LILY("Лилия"),
    HYDRANGEA("Гортензия"),
    PEONY("Пион"),
    CHAMOMILE("Ромашка"),
    GYPSOFHILA("Гипсофила"),
    LEVENDER("Лаванда"),
    MIMOSA("Мимоза"),
    CARNATION("Гвоздика"),
    GLADIOLUS("Гладиолус");
    private final String type;
    FlowersType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
