package Service.MusicService.Factory;

import Service.MusicService.Composition.Composition;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GenerateCompositionList {
    private final RandomCompositionFactory factory;
    private final int count;

    public GenerateCompositionList(int count) {
        this.factory = new RandomCompositionFactory();
        this.count = count;
    }

    public Collection<Composition> getListOfCompositions() {
        return Stream.generate(factory::getComposition)
                .limit(count)
                .collect(Collectors.toList());
    }
}
