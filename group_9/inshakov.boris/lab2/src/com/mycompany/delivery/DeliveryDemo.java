package com.mycompany.delivery;

public class DeliveryDemo {
    public static void main(String[] args) {
        StandardDelivery sd = new StandardDelivery("123", "221B Baker Street");
        ExpressDelivery ed = new ExpressDelivery("456", "742 Evergreen Terrace", 19.99);

        processDelivery(sd);
        processDelivery(ed);
    }

    public static void processDelivery(Delivery delivery) {
        if (delivery instanceof StandardDelivery) {
            System.out.println("Обрабатывается стандартная доставка: " + delivery.deliver());
        } else if (delivery instanceof ExpressDelivery) {
            System.out.println("Обрабатывается экспресс-доставка: " + delivery.deliver());
        } else {
            System.out.println("Неизвестный тип доставки: " + delivery.deliver());
        }
    }
}
