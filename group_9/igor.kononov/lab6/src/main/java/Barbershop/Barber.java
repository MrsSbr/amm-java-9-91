package Barbershop;

import lombok.Data;
import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

@Data
public class Barber implements Runnable {
    private static final int WORK_TIME = 3000;
    private final Reception reception;
    private Client currentClient;

    public Barber(Reception reception) {
        this.reception = reception;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            var workPlace = reception.getWorkplace();
            synchronized (workPlace) {
                workPlace.setClient(null);
                workPlace.setFree(true);
                workPlace.notify();
            }

            var freeReception = true;
            var clientQueue = reception.getClientQueue();

            synchronized (clientQueue) {
                if (!clientQueue.isEmpty()) {
                    freeReception = false;
                    currentClient = clientQueue.poll();
                    clientQueue.notify();
                }
            }

            synchronized (workPlace) {
                if (freeReception) {
                    System.out.println("Барбер спит");
                    workPlace.wait();
                    currentClient = workPlace.getClient();
                }
            }

            workPlace.setClient(currentClient);
            workPlace.setFree(false);
            System.out.println("Барбер работает с " + currentClient.getName());
            sleep(WORK_TIME);
            System.out.println("Барбер подстриг " + currentClient.getName());
        }
    }
}
