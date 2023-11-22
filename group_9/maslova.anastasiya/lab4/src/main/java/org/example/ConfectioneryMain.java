package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.example.Input.getIntInRange;

/*
Кондитерская ведет учёт выполненных заказов, для этого в файл записывается информация в следующем формате:
дата выполнения заказа;наименование торта;масса;стоимость

- найти месяц, в котором кондитерская получила самый низкий доход
- вывести самый тяжелый торт в каждом месяце этого года
- вывести список заказов тортов по месяцам
 */

public class ConfectioneryMain {
    private static final Logger logger = LogManager.getLogger(ConfectioneryMain.class);

    public static void main(String[] args) {
        logger.info("Начало работы программы.");
        int choice = 1;
        Confectionery confectionery = new Confectionery();
        while (choice != 0) {
            confectionery.printMenu();
            choice = getIntInRange(0, 3);
            switch (choice) {
                case 1 -> confectionery.printTheLeastProfitableMonth();
                case 2 -> confectionery.printTheHeaviestCakeInEveryMonthOfThisYear();
                case 3 -> confectionery.printOrdersByMonth();
                case 0 -> System.out.println("До свидания...");
            }
        }
        logger.info("Конец работы программы.");
    }
}