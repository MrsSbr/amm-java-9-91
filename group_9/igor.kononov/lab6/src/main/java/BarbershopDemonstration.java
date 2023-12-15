import Barbershop.Barber;
import Barbershop.Client;
import Barbershop.Reception;

import java.util.List;

public class BarbershopDemonstration {
    public static void main(String[] args) {
        var reception = new Reception(2);
        var barber = new Barber("Сергей", reception);

        List<Client> clients = List.of(
                new Client("Александр", reception),
                new Client("Владислав", reception),
                new Client("Артем", reception),
                new Client("Максим", reception),
                new Client("Игорь", reception)
        );

        var barberThread = new Thread(barber);
        barberThread.start();

        for (var client : clients) {
            var clientThread = new Thread(client);
            clientThread.start();
        }
    }
}
