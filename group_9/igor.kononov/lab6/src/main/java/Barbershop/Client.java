package Barbershop;

import Barbershop.Reception;
import lombok.Data;
import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

@Data
public class Client implements Runnable {
    private static final int WAIT = 3000;
    private final String name;
    private final Reception reception;
    private boolean tonsured = false;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            sleep(WAIT);

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

                        clientQueue.wait();
                    }
                    else {
                        System.out.println(name + " ушел, мест нет");
                    }
                }
            }
        }
    }
}
