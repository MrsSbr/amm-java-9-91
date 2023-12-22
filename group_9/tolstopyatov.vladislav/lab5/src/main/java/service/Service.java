package service;

import service.IService;

import java.util.List;

public class Service implements IService {

    @Override
    public void do1() {
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                sum += i * 2;
            } else {
                sum += (i / 2) + 1;
            }
        }
    }

    @Override
    public void do2() {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> strs = List.of("I", "Like", "JAVA");

        for (String str : strs) {
            stringBuilder.append(str);
        }
    }
}
