package orchestra;

public class StringedInstrument extends MusicalInstrument {
    int stringCount;

    public StringedInstrument(String name, int stringCount, boolean isTune) {
        super(name, isTune);
        this.stringCount = stringCount;
    }

    public int getStringCount() {
        return stringCount;
    }

    public void setStringCount(int stringCount) {
        this.stringCount = stringCount;
    }

    @Override
    public void play() {
        System.out.println("Играем на струнном инструменте: " + getName());
    }

    @Override
    public void tune() {
        if (getIsTune()) {
            System.out.println("Инструмент уже настроен");
        } else {
            System.out.println("Настройка звука струнного инструмента: " + getName());
            setIsTune(true);
        }
    }

    @Override
    public String toString() {
        return "Струнный инструмент: " + super.toString();
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
        StringedInstrument other = (StringedInstrument) obj;
        return stringCount == other.stringCount;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + stringCount;
    }
}
