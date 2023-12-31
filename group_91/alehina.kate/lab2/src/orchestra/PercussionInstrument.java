package orchestra;

public class PercussionInstrument extends MusicalInstrument {
    public enum TypePercussionInstrument {
        SMOOTHSOUNDING,
        PLASTIC,
        WEBBED
    }
    TypePercussionInstrument type; // самозвучащие, пластинчатые или перепончатые
    public PercussionInstrument(String name, TypePercussionInstrument type, boolean isTune) {
        super(name, isTune);
        this.type = type;
    }

    public TypePercussionInstrument getType() {
        return type;
    }

    public void setType(TypePercussionInstrument type) {
        this.type = type;
    }

    @Override
    public void play() {
        System.out.println("Играем на ударном инструменте: " + getName());
    }

    @Override
    public void tune() {
        if (getIsTune()) {
            System.out.println("Инструмент уже настроен");
        } else {
            System.out.println("Настройка звука ударного инструмента: " + getName());
            setIsTune(true);
        }
    }

    @Override
    public String toString() {
        return "Ударный инструмент: " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        if (!super.equals(obj)){
            return false;
        }
        PercussionInstrument other = (PercussionInstrument) obj;
        return type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + type.hashCode();
    }
}
