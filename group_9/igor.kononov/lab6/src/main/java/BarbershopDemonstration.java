import Barbershop.Barber;
import Barbershop.Client;
import Barbershop.Reception;

import java.util.List;

public class BarbershopDemonstration {
    public static void main(String[] args) throws InterruptedException {
        var queueSize = 2;
        var reception = new Reception(queueSize);

        var barber = new Barber(reception);
        var barberThread = new Thread(barber);
        barberThread.start();

        // Пробуждение барбера первый раз
        var clientThread = new Thread(new Client("Игорь", reception));
        clientThread.start();
        clientThread.join();

        // Пробуждение барбера после повторного засыпания
        var clientThreadsNew = List.of(
                new Thread(new Client("Александр", reception)),
                new Thread(new Client("Владислав", reception)),
                new Thread(new Client("Артем", reception)),
                new Thread(new Client("Максим", reception))
        );
        
        // Приостановка старта новых потоков, чтобы барбер успел вновь уснуть
        Thread.sleep(4000);

        for (var clientThreadNew : clientThreadsNew) {
            clientThreadNew.start();
        }

        for (var clientThreadNew : clientThreadsNew) {
            clientThreadNew.join();
        }
    }
}
