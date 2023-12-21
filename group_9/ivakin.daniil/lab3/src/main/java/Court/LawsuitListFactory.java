package Court;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LawsuitListFactory {
    private static int count;

    static {
        count = 6490;
    }

    public static void setCount(int count) {
        LawsuitListFactory.count = count;
    }

    public static List<Lawsuit> getLawsuitList() {
        return Stream.generate(LawsuitFactory::getLawsuit)
                .limit(count)
                .collect(Collectors.toList());
    }
}
