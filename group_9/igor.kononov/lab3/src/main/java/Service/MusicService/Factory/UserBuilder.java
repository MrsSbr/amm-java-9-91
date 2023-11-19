package Service.MusicService.Factory;

import Service.MusicService.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserBuilder {
    private final RandomUserFactory factory;
    private final int count;

    public UserBuilder(RandomUserFactory factory, int count) {
        this.factory = factory;
        this.count = count;
    }

    public List<User> getListOfUsers() {
        return Stream.generate(factory::getUser)
                .limit(count)
                .collect(Collectors.toList());
    }
}
