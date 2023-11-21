package Court;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LawsuitListFactory {
    private LawsuitFactory lawsuitFactory;
    private int count;

    public LawsuitListFactory(int count) {
        lawsuitFactory = new LawsuitFactory();
        this.count = count;
    }

    public List<Lawsuit> getLawsuitList() {
        return Stream.generate(lawsuitFactory::getLawsuit)
                .limit(count)
                .collect(Collectors.toList());
    }
}
