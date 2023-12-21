package Service.MusicService.Factory;

import Service.MusicService.User;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateUserList {
    private final RandomUserFactory factory;
    private final int count;

    public GenerateUserList(int count) {
        this.factory = new RandomUserFactory();
        this.count = count;
    }

    public Collection<User> getListOfUsers() {
        return Stream.generate(factory::getUser)
                .limit(count)
                .collect(Collectors.toList());
    }
}
