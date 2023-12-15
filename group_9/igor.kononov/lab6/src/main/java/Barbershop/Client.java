package Barbershop;

import lombok.Data;

import static java.lang.Thread.sleep;

@Data
public class Client implements Runnable {
    private static final int WAIT = 3000;
    private final String name;
    private final Reception reception;
    private boolean tonsured = false;


    @Override
    public void run() {
        while (true) {
            try {
                sleep(WAIT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            var workPlace = reception.getWorkplace();
            synchronized (workPlace) {
                if (workPlace.isFree()) {
                    workPlace.setClient(this);
                    workPlace.setFree(false);
                    System.out.println(name + " пришел, барбер проснулся");
                    tonsured = true;
                }
            }
            if (!tonsured) {
                var clientQueue = reception.getClientQueue();
                synchronized (clientQueue) {
                    if (clientQueue.size() < reception.getQueueSize()) {
                        reception.addClient(this);
                        System.out.println(name + " встал в очередь");

                        try {
                            clientQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        System.out.println(name + " ушел, мест нет");
                    }
                }
            }
        }
    }
}
