import orchestra.*;


public class Orchestra {
    public static void main(String[] args) {
        MusicalInstrument [] instruments = new MusicalInstrument[6];
        instruments[0] = new StringedInstrument("Скрипка", 4, true);
        instruments[1] = new PercussionInstrument("Барбаны", "Перепончатый", false);
        instruments[2] = new WindInstrument("Труба", "Медный", true);
        instruments[3] = new WindInstrument("Флейта", "Деревянный", false);
        instruments[4] = new StringedInstrument("Гитара", 6, false);
        instruments[5] = new PercussionInstrument("Треугольник", "Самозвучащий", true);

        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument);
            System.out.println("Настройка инструментов перед выступлением: ");

            if (instrument instanceof StringedInstrument strInstrument) {
                System.out.println( "Количество струн: " +
                        strInstrument.getStringCount());
            }
            if (instrument instanceof WindInstrument windInstrument) {
                System.out.println( "Тип духового инструмента: " +
                        windInstrument.getType());
            }
            if (instrument instanceof PercussionInstrument percussInstrument) {
                System.out.println( "Тип ударного инструмента: " +
                        percussInstrument.getType());
            }

            instrument.tune();
            instrument.play();
        }
    }
}