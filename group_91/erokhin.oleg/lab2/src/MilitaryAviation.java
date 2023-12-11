package src;

import src.Aircrafts.Aircraft;
import src.Aircrafts.Bomber;
import src.Aircrafts.Fighter;

public class MilitaryAviation {
    public static void main(String[] args) {
        Aircraft fighter = new Fighter("F-16");
        Aircraft bomber = new Bomber("B-52");

        System.out.println(fighter);
        System.out.println(bomber);

        fighter.fly();
        fighter.refuel();

        bomber.fly();
        bomber.refuel();

        Aircraft fighter2 = new Fighter("F-16");
        System.out.println(fighter.equals(fighter2));

        Aircraft bomber2 = new Bomber("B-50");
        System.out.println(bomber.equals(bomber2));
    }
}