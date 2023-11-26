package factory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductionInfo {
    private final Collection<Part> parts;

    public ProductionInfo(Collection<Part> parts) {
        this.parts = parts;
    }

    public long getPartTypeCount(PartType partType) {
        return parts.stream()
                .filter(part -> part.getPartType() == partType)
                .count();
    }

    public List<Part> getUniqueParts() {
        return parts.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
