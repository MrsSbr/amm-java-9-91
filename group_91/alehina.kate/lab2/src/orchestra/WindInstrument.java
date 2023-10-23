package orchestra;

public class WindInstrument extends MusicalInstrument {
    private String type; // деревянный или медный

    public WindInstrument(String name, String type, boolean isTune) {
        super(name, isTune);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void play() {
        System.out.println("Играем на духовом инструменте: " + getName());
    }

    @Override
    public void tune() {
        if (getIsTune()) {
            System.out.println("Инструмент уже настроен");
        } else {
            System.out.println("Настройка звука духового инструмента: " + getName());
            setIsTune(true);
        }
    }

    @Override
    public String toString() {
        return "Духовой инструмент: " + super.toString() ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        WindInstrument other = (WindInstrument) obj;
        return type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + type.hashCode();
    }
}
