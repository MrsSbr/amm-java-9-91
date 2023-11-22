import Service.MusicService.CollectionPerformanceComparison;
import Service.MusicService.Factory.GenerateUserList;
import Service.MusicService.MusicService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;
import java.util.LinkedHashSet;

public class PerfomanceCollections {
    public static void main(String[] args) {

        var users = new GenerateUserList(500).getListOfUsers();

        InvokePerfomanceTest(new MusicService(new ArrayList<>(users)), "First test");


        InvokePerfomanceTest(new MusicService(new LinkedList<>(users)), "LinkedList");
        InvokePerfomanceTest(new MusicService(new Vector<>(users)), "Vector");
        InvokePerfomanceTest(new MusicService(new HashSet<>(users)), "HashSet");
        InvokePerfomanceTest(new MusicService(new LinkedHashSet<>(users)), "LinkedHashSet");
        InvokePerfomanceTest(new MusicService(new ArrayList<>(users)), "ArrayList");
    }

    private static void InvokePerfomanceTest(MusicService musicService, String name) {
        CollectionPerformanceComparison tester = new CollectionPerformanceComparison(musicService, name);
        tester.testMethodsPerformance();
    }
}
