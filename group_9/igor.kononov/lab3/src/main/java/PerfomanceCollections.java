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

        InvokePerfomanceTest(new MusicService(new ArrayList<>(users)));
        InvokePerfomanceTest(new MusicService(new LinkedList<>(users)));
        InvokePerfomanceTest(new MusicService(new Vector<>(users)));
        InvokePerfomanceTest(new MusicService(new HashSet<>(users)));
        InvokePerfomanceTest(new MusicService(new LinkedHashSet<>(users)));
        InvokePerfomanceTest(new MusicService(new ArrayList<>(users)));
    }

    private static void InvokePerfomanceTest(MusicService musicService) {
        var tester = new CollectionPerformanceComparison(musicService);
        tester.testMethodsPerformance();
    }
}
