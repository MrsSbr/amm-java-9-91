package org.example;

public class CultureDepartment {
    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            CultureDepartmentService.printMainMenu();
            choice = Input.getIntInRange(0, 2);
            switch (choice) {
                case 1 -> CultureDepartmentService.testing();
                case 2 -> CultureDepartmentService.performanceTest();
                case 0 -> System.out.println("До свидания...");
            }
        }

    }
}