import Poetry.InspirationProcess;
import Poetry.Poet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Demonstration {

    private static final String RESOURCES_PATH = "group_9/ivakin.daniil/lab6/src/main/resources/";

    public static void main(String[] args) {
        List<Poet> poets = new ArrayList<>();

        try {
            poets.add(new Poet("Пушкин", Files.readAllLines(Path.of(RESOURCES_PATH + "Пророк.txt"))));
            poets.add(new Poet("Есенин", Files.readAllLines(Path.of(RESOURCES_PATH + "C Добрым Утром.txt"))));
            poets.add(new Poet("Цветаева", Files.readAllLines(Path.of(RESOURCES_PATH + "Молитва.txt"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        InspirationProcess inspirationProcess = new InspirationProcess(poets);
        ConcurrentLinkedQueue<String> resultPoem = inspirationProcess.beginInspitrationProcces();

        while (!resultPoem.isEmpty()) {
            System.out.println(resultPoem.poll());
        }
    }
}