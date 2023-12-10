package org.example;

/*
В барбершопе работает один барбер, есть одно рабочее место и приёмная с несколькими стульями.
Когда барбер заканчивает подстригать клиента, он отпускает клиента и затем идёт в приёмную,
чтобы посмотреть, есть ли там ожидающие клиенты.
Если они есть, он приглашает одного из них и стрижёт его.
Если ждущих клиентов нет, он возвращается к своему креслу и спит в нём.

Каждый приходящий клиент смотрит на то, что делает барбер.
Если барбер спит, то клиент будит его и садится в кресло.
Если барбер работает, то клиент идёт в приёмную.
Если в приёмной есть свободный стул, клиент садится и ждёт своей очереди.
Если свободного стула нет, то клиент уходит.

Необходимо имитировать работу барбершопа средствами многопоточного программирования
*/


import BarberShop.Barber;
import BarberShop.Reception;
import Visitors.Visitor;

import java.util.List;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        Reception reception = new Reception();
        Barber barber = new Barber("дядя Толик", reception);

        List<Visitor> visitors = List.of(
                new Visitor("Александр", reception, false),
                new Visitor("Константин", reception, false),
                new Visitor("Николай", reception, false),
                new Visitor("Владислав", reception, false),
                new Visitor("Артём", reception, false),
                new Visitor("Игорь", reception, false),
                new Visitor("Даниил", reception, false),
                new Visitor("Андрей", reception, false),
                new Visitor("Егор", reception, false),
                new Visitor("Женя", reception, false)
        );

        barber.start();

        for (Visitor visitor : visitors) {
            visitor.start();
        }
        /*
        for (Visitor visitor : visitors) {
            visitor.join();
        }
         */
    }
}