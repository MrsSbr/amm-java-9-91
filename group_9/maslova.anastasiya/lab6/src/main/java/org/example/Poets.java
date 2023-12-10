package org.example;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Poets {
    private static final List<Path> PATHS = List.of(
            Path.of("maslova.anastasiya/lab6/src/main/resources/Pushkin.txt"),
            Path.of("maslova.anastasiya/lab6/src/main/resources/Esenin.txt"),
            Path.of("maslova.anastasiya/lab6/src/main/resources/Shnur.txt"),
            Path.of("maslova.anastasiya/lab6/src/main/resources/Cvetaeva.txt")
    );

    public static void main(String[] args) throws InterruptedException {
        Napkin napkin = new Napkin();
        MyFileReader myFileReader = new MyFileReader();

        List<Writer> writers = new ArrayList<>();

        for (Path path : PATHS) {
            writers.add(new Writer(
                    myFileReader.readOrdersFromFile(path),
                    napkin
            ));
        }

        for (Writer writer : writers) {
            writer.start();
        }

        for (Writer writer : writers) {
            writer.join();
        }
        System.out.println(napkin.getPoem());
    }
}