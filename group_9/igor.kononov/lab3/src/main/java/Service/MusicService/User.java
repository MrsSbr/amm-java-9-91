package Service.MusicService;

import Service.MusicService.Composition.Composition;
import lombok.Data;

import java.util.Collection;

@Data
public class User {

    private String firstName;
    private String secondName;
    private Collection<Composition> listenedTracks;


    public User(String firstName, String secondName, Collection<Composition> listenedTracks) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.listenedTracks = listenedTracks;
    }
}
