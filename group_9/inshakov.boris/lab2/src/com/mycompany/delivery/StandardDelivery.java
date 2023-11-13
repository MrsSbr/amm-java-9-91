package com.mycompany.delivery;

public class StandardDelivery extends AbstractDelivery {

    public StandardDelivery(String packageCode, String destination) {
        super(packageCode, destination);
    }

    @Override
    public String deliver() {
        return "Standard Delivery to " + destination + " with package code " + packageCode;
    }
}