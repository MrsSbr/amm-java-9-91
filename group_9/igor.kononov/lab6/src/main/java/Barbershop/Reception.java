package Barbershop;

import lombok.Data;

import java.util.Queue;

import java.util.concurrent.LinkedBlockingQueue;

@Data
public class Reception {
    private final int queueSize;
    private final Queue<Client> clientQueue;
    private final Workplace workplace;

    public Reception(int queueSize) {
        this.queueSize = queueSize;
        clientQueue = new LinkedBlockingQueue<>(this.queueSize);
        workplace = new Workplace();
    }

    public void addClient(Client client) {
        clientQueue.add(client);
    }
}
