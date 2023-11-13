package ats;

import sortedcontainer.SortedCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class UsersDirectory {

    private final SortedCollection<User> collection;

    public UsersDirectory(Function<Comparator<User>, SortedCollection<User>> collectionProducer) {
        collection = collectionProducer.apply(Comparator
                .comparing(User::atsId)
                .thenComparing(User::id));
    }

    private static void addLastRange(List<AtsNumbersRange> result, int currentUserId, int currentAts) {
        if (currentUserId != User.MAX_USER_ID) {
            result.add(new AtsNumbersRange(
                    currentAts,
                    currentUserId + 1,
                    User.MAX_USER_ID
            ));
        }
    }

    public Collection<User> getUsers() {
        return collection.getUnmodifiableView();
    }

    public void addUser(User user) {
        collection.add(user);
    }

    public List<AtsNumbersRange> getFreeNumbersRanges() {
        if (collection.isEmpty()) {
            return Collections.emptyList();
        }

        var result = new ArrayList<AtsNumbersRange>();
        var iterator = collection.iterator();

        int currentAts = -1;
        int currentUserId = User.MAX_USER_ID;

        while (iterator.hasNext()) {
            var user = iterator.next();
            if (user.atsId() != currentAts) {
                addLastRange(result, currentUserId, currentAts);
                currentAts = user.atsId();
                currentUserId = -1;
            }
            if (user.id() - currentUserId > 1) {
                result.add(new AtsNumbersRange(
                        currentAts,
                        currentUserId + 1,
                        user.id() - 1
                ));
            }
            currentUserId = user.id();
        }

        addLastRange(result, currentUserId, currentAts);
        return result;
    }

    public List<AtsUsersCount> getUsersStatistic() {
        if (collection.isEmpty()) {
            return Collections.emptyList();
        }

        var result = new ArrayList<AtsUsersCount>();
        var iterator = collection.iterator();

        int currentAts = iterator.next().atsId();
        int count = 1;

        while (iterator.hasNext()) {
            var user = iterator.next();
            if (user.atsId() != currentAts) {
                result.add(new AtsUsersCount(currentAts, count));
                currentAts = user.atsId();
                count = 1;
            } else {
                ++count;
            }
        }

        result.add(new AtsUsersCount(currentAts, count));
        return result;
    }

}
