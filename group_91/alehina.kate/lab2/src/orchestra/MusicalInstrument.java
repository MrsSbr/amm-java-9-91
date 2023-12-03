package orchestra;

import java.util.Objects;

public abstract class MusicalInstrument implements Instrument {
    private String name;
    private boolean isTune;

    public MusicalInstrument(String name, boolean isTune) {
        this.name = name;
        this.isTune = isTune;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsTune() {
        return isTune;
    }

    public void setIsTune(boolean isTune) {
        this.isTune = isTune;
    }

    public abstract void tune();

    @Override
    public String toString() {
        return name + ". ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        MusicalInstrument other = (MusicalInstrument) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
