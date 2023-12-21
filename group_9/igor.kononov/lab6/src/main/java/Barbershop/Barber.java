package Barbershop;

import lombok.Data;

import static java.lang.Thread.sleep;

@Data
public class Barber implements Runnable {
    private static final int WORK_TIME = 3000;
    private final Reception reception;
    private Client currentClient;

    public Barber(Reception reception) {
        this.reception = reception;
    }

    @Override
    public void run() {

        while (true) {
            var workPlace = reception.getWorkplace();
            synchronized (workPlace) {
                workPlace.setFree(true);
                workPlace.notify();
            }

            var freeReception = true;
            var clientQueue = reception.getClientQueue();
            synchronized (clientQueue) {
                if (!clientQueue.isEmpty()) {
                    freeReception = false;
                    currentClient = clientQueue.poll();
                    clientQueue.notifyAll();
                }
            }
            synchronized (workPlace) {
                if (freeReception) {
                    System.out.println("Барбер спит");
                    try {
                        workPlace.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    currentClient = workPlace.getClient();
                }
            }

            workPlace.setClient(currentClient);
            workPlace.setFree(false);
            System.out.println("Барбер работает с " + currentClient.getName());
            try {
                sleep(WORK_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Барбер подстриг " + currentClient.getName());
            workPlace.setFree(true);
            workPlace.setClient(null);
        }
    }
}
