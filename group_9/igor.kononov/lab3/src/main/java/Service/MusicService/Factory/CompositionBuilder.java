package Service.MusicService.Factory;

import Service.MusicService.Composition.Composition;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CompositionBuilder {
    private final RandomCompositionFactory factory;
    private final int count;

    public CompositionBuilder(int count) {
        this.factory = new RandomCompositionFactory();
        this.count = count;
    }

    public List<Composition> getListOfCompositions() {
        return Stream.generate(factory::getComposition)
                .limit(count)
                .collect(Collectors.toList());
    }
}
