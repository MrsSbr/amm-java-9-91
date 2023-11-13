import ats.User;
import ats.UsersDirectory;
import sortedcontainer.SortedList;
import sortedcontainer.TreeSetWrapper;
import java.time.Duration;
import java.time.Instant;

public class AtsDemo {

    private static void testAts(UsersDirectory usersDirectory) {
        var randomAtsId = new UniqueRandom(0, 99);
        for (int i = 0; i < 30; ++i) {
            int atsId = randomAtsId.getNext();
            var randomUserId = new UniqueRandom(0, 99999);
            for (int j = 0; j < 1000; ++j) {
                int id = randomUserId.getNext();
                usersDirectory.addUser(new User(
                        "John Doe №" + id,
                        atsId,
                        id
                ));
            }
        }
        usersDirectory.getFreeNumbersRanges();
        usersDirectory.getUsersStatistic();
    }

    private static void runBenchmark(UsersDirectory usersDirectory, String testName) {
        var start = Instant.now();
        testAts(usersDirectory);
        var total = Duration.between(start, Instant.now());
        System.out.println(testName + ": " + total.toNanos() / 1e9 + "s");
    }

    public static void main(String[] args) {
        runBenchmark(new UsersDirectory(TreeSetWrapper::new), "Tree set");
        runBenchmark(new UsersDirectory(SortedList::sortedArrayList), "Array list");
        runBenchmark(new UsersDirectory(SortedList::sortedLinkedList), "Linked list");
    }

}
