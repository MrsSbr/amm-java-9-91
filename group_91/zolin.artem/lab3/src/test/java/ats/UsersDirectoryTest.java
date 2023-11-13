package ats;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import sortedcontainer.TreeSetWrapper;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersDirectoryTest {

    UsersDirectory usersDirectory = new UsersDirectory(TreeSetWrapper::new);

    User[] users = {
            new User("", 4, 234),
            new User("", 3, 0),
            new User("", 99, 1000),
            new User("", 2, 99999),
            new User("", 4, 1),
            new User("", 99, 267)
    };

    AtsUsersCount[] expectedUsersCount = {
            new AtsUsersCount(2, 1),
            new AtsUsersCount(3, 1),
            new AtsUsersCount(4, 2),
            new AtsUsersCount(99, 2)
    };

    AtsNumbersRange[] expectedNumbersRanges = {
            new AtsNumbersRange(4, 0, 0),
            new AtsNumbersRange(4, 2, 233),
            new AtsNumbersRange(4, 235, 99999),
            new AtsNumbersRange(99, 0, 266),
            new AtsNumbersRange(99, 268, 999),
            new AtsNumbersRange(99, 1001, 99999),
            new AtsNumbersRange(3, 1, 99999),
            new AtsNumbersRange(2, 0, 99998)
    };

    @BeforeAll
    void setUsers() {
        for (var user : users) {
            usersDirectory.addUser(user);
        }
    }

    @Test
    @DisplayName("Количество пользователей должно правильно определяться")
    void usersCountShouldBeDeterminedCorrectly() {
        var usersCount = usersDirectory.getUsersStatistic();
        assertThat(usersCount).containsExactlyInAnyOrder(expectedUsersCount);
    }

    @Test
    @DisplayName("Пользователи должны быть отсортированы")
    void usersShouldBeSorted() {
        var users = usersDirectory.getUsers().toArray(User[]::new);
        assertThat(users).isSortedAccordingTo(Comparator.comparing(User::getPhoneNumber));
    }

    @Test
    @DisplayName("Диапазоны свободных номеров должны правильно определяться")
    void numberRangesShouldBeDeterminedCorrectly() {
        var numbersRanges = usersDirectory.getFreeNumbersRanges();
        assertThat(numbersRanges).containsExactlyInAnyOrder(expectedNumbersRanges);
    }

    @Test
    @DisplayName("Для пустых коллекций высчитанные статистики пустые")
    void emptyCollectionsShouldProduceEmptyStatistics() {
        var emptyCollection = new UsersDirectory(TreeSetWrapper::new);
        var usersCount = emptyCollection.getUsersStatistic();
        var numbersRanges = emptyCollection.getFreeNumbersRanges();
        assertThat(usersCount).isEmpty();
        assertThat(numbersRanges).isEmpty();
    }

}
