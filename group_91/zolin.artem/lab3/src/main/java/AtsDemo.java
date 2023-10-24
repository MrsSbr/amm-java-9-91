import ats.User;
import ats.UsersCollection;

public class AtsDemo {

    private static UsersCollection generateAts() {
        var usersCollection = new UsersCollection();
        var randomAtsId = new UniqueRandom(0, 99);
        for (int i = 0; i < 20; ++i) {
            int atsId = randomAtsId.getNext();
            var randomUserId = new UniqueRandom(0, 99999);
            for (int j = 0; j < 1000; ++j) {
                int id = randomUserId.getNext();
                usersCollection.addUser(new User(
                        "John Doe №" + id,
                        atsId,
                        id
                ));
            }
        }
        return usersCollection;
    }

    public static void main(String[] args) {
        var usersCollection = generateAts();

        var usersCount = usersCollection.getUsersStatistic();
        for (var countInfo : usersCount) {
            System.out.printf("АТС №%d: %d пользователей\n", countInfo.atsId(), countInfo.usersCount());
        }

        var numbersRanges = usersCollection.getFreeNumbersRanges();
        for (var range : numbersRanges) {
            if (range.start() != range.end()) {
                System.out.printf("АТС №%d: [%d-%d]\n",
                        range.atsId(), range.start(), range.end());
            } else {
                System.out.printf("АТС №%d: {%d}\n",
                        range.atsId(), range.start());
            }
        }
    }

}
