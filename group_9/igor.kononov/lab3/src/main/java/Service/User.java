package Service;

import Composition.Composition;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class User {
    private String firstName;
    private String secondName;
    private Collection<Composition> listenedTracks;
}
