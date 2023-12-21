package Visitors;

import BarberShop.Reception;

import java.util.Random;

public class Visitor extends Thread {
    private final String visitorName;
    private final Reception reception;
    private boolean isTonsured; // пострижен ли

    public Visitor(String visitorName, Reception reception, boolean isTonsured) {
        this.visitorName = visitorName;
        this.reception = reception;
        this.isTonsured = isTonsured;
    }

    public Reception getReception() {
        return reception;
    }

    public String getVisitorName() {
        return visitorName;
    }

    @Override
    public void run() {
        try {
            sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // сначала проверяем спит ли барбер или нет(признак этого - пустой рабочий стул)
        synchronized (reception.getWorkChair()) {
            if (reception.getWorkChair().isFree()) {
                isTonsured = true;
                reception.getWorkChair().setVisitor(this);
                reception.getWorkChair().setFree(false);
                System.out.printf("Пришел клиент %s,Барбер,просыпайся!\n\n", visitorName);
                reception.getWorkChair().notify();
            }
        }
        // иначе идем в очередь
        if (!isTonsured) {
            synchronized (reception.getReception()) {
                if (reception.getReception().size() != reception.getRECEPTION_MAX_SIZE()) {
                    reception.addVisitor(this);
                    System.out.printf("Пришел клиент %s и ждет в приемной\n\n", visitorName);
                    try {
                        while (reception.getReception().contains(this)) {
                            reception.getReception().wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {                // если в очередь не попали, то уходим(по условию)
                    System.out.printf("Пришел клиент %s и ушел, потому что приемная полная!\n\n", visitorName);
                }
            }
        }
    }
}
