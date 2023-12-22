package Barbershop;

import lombok.Data;
import lombok.SneakyThrows;


@Data
public class Client implements Runnable {
    private static final int WAIT = 1000;
    private final String name;
    private final Reception reception;
    private boolean tonsured = false;


    @SneakyThrows
    @Override
    public void run() {

        try {
            Thread.sleep(WAIT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var workPlace = reception.getWorkplace();
        synchronized (workPlace) {
            if (workPlace.isFree()) {
                tonsured = true;
                workPlace.setClient(this);
                workPlace.setFree(false);
                System.out.println(name + " пришел, барбер проснулся");
                workPlace.notify();
            }
        }

        if (!tonsured) {
            var clientQueue = reception.getClientQueue();
            if (clientQueue.size() < reception.getQueueSize()) {
                reception.addClient(this);
                System.out.println(name + " встал в очередь");
            } else {
                System.out.println(name + " ушел, мест нет");
            }
        }

//        if (!tonsured) {
//            var clientQueue = reception.getClientQueue();
//            synchronized (clientQueue) {
//                if (clientQueue.size() < reception.getQueueSize()) {
//                    reception.addClient(this);
//                    System.out.println(name + " встал в очередь");
//                    while (clientQueue.contains(this)) {
//                        clientQueue.wait();
//                    }
//                } else {
//                    System.out.println(name + " ушел, мест нет");
//                }
//            }
//        }
    }
}
