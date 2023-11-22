package Service.MusicService.Composition;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class Composition {

    private String name;
    private String composer;
    private LocalDate date;

    public Composition(String name, String composer) {
        this.name = name;
        this.composer = composer;
        this.date = LocalDate.now();
    }

    public Composition(String name, String composer, LocalDate date) {
        this.name = name;
        this.composer = composer;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composition that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(composer, that.composer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, composer);
    }
}