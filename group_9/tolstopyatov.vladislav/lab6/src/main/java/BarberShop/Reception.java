package BarberShop;

import Visitors.Visitor;

import java.util.ArrayDeque;
import java.util.Queue;

public class Reception { // приемная
    private static final Integer RECEPTION_MAX_SIZE = 5;
    private final Queue<Visitor> reception;
    private final WorkChair workChair;

    public Reception() {
        reception = new ArrayDeque<>(RECEPTION_MAX_SIZE);
        this.workChair = new WorkChair(true);
    }

    public Queue<Visitor> getReception() {
        return reception;
    }

    public Integer getRECEPTION_MAX_SIZE() {
        return RECEPTION_MAX_SIZE;
    }

    public WorkChair getWorkChair() {
        return workChair;
    }

    public void addVisitor(Visitor visitor) {
        reception.add(visitor);
    }

}
