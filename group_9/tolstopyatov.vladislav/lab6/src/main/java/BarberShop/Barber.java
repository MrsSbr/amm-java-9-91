package BarberShop;

import Visitors.Visitor;

public class Barber extends Thread {
    private final String barberName;
    private final Integer WORKING_TIME = 2000;
    private final Reception reception;
    private Visitor currentVisitor;

    public Barber(String barberName, Reception reception) {
        this.barberName = barberName;
        this.reception = reception;
        this.setName("Барбер");
    }

    public String getBarberName() {
        return barberName;
    }

    public Integer getWORKING_TIME() {
        return WORKING_TIME;
    }

    public Reception getReception() {
        return reception;
    }

    @Override
    public void run() {
        while (true) {
            // установка стула в свободное положение
            synchronized (reception.getWorkChair()) {
                reception.getWorkChair().setVisitor(null);
                reception.getWorkChair().setFree(true);
                reception.getWorkChair().notify();
            }
            // проверка очереди на пустоту
            boolean isFreeReception;
            synchronized (reception.getReception()) {
                if (reception.getReception().isEmpty()) {
                    isFreeReception = true;
                } else {
                    // забираем человека из очереди
                    isFreeReception = false;
                    currentVisitor = reception.getReception().poll();
                    reception.getReception().notifyAll();
                }
            }
            synchronized (reception.getWorkChair()) {
                // если очередь пустая, то барбер спит
                if (isFreeReception) {
                    try {
                        System.out.printf("Барбер %s спит, клиентов нет!\n", barberName);
                        reception.getWorkChair().wait();
                        currentVisitor = reception.getWorkChair().getVisitor();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {    // иначе надо указать, что стул занят
                    reception.getWorkChair().setFree(false);
                    reception.getWorkChair().setVisitor(currentVisitor);
                }
            }

            System.out.printf("Барбер %s работает с клиентом %s!\n", barberName, currentVisitor.getVisitorName());
            try {
                sleep(WORKING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Барбер %s обслужил клиента %s\n", barberName, currentVisitor.getVisitorName());
        }
    }
}
