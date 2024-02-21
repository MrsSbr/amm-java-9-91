package entity;

import logic.GeneratorSql;
import logic.GeneratorSqlTests;

public class SampleWork {
    public static void main(String[] args) {
        System.out.println("Запуск программы тестирования SQL-генератора...");

        // Запуск тестов
        org.testng.TestNG testng = new org.testng.TestNG();
        testng.setTestClasses(new Class[]{GeneratorSqlTests.class});
        testng.run();

        // Пример генерации SQL-запроса и его вывод
        Class<?> animeClass = Philosopher.class;
        String sampleQuery = GeneratorSql.generateSampleQuery(animeClass);
        System.out.println("Пример генерации SQL-запроса: " + sampleQuery);

        System.out.println("Программа завершена.");
    }
}
