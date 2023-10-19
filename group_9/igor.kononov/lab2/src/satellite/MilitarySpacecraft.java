package src.satellite;

import java.util.List;

public interface MilitarySpacecraft {
    List<Satellite> targeting(List<Satellite> satellite, StringBuilder stringBuilder);
}
