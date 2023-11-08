package com.mycompany.delivery;

public class DeliveryDemo {
    public static void main(String[] args) {
        StandardDelivery sd = new StandardDelivery("123", "221B Baker Street");
        ExpressDelivery ed = new ExpressDelivery("456", "742 Evergreen Terrace", 19.99);

        System.out.println(sd);
        System.out.println(ed);

        // Проверка instanceof и вызов метода processDelivery
        if (sd instanceof Delivery) {
            DeliveryService.processDelivery(sd);
        }

        if (ed instanceof Delivery) {
            DeliveryService.processDelivery(ed);
        }
    }
}