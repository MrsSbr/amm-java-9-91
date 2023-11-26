package factory;

import java.util.Objects;

public class Part {
    private final int partId;
    private final PartType partType;

    public Part(int partId, PartType partType) {
        this.partId = partId;
        this.partType = partType;
    }

    public int getDetailId() {
        return partId;
    }

    public PartType getPartType() {
        return partType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return partId == part.partId &&
                partType == part.partType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partId, partType);
    }

    @Override
    public String toString() {
        return "Part{" +
                "uniqueNumber='" + partId + '\'' +
                ", partType=" + partType +
                '}';
    }
}
