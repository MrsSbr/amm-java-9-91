import orchestra.*;


public class Orchestra {
    public static void main(String[] args) {
        MusicalInstrument [] instruments = new MusicalInstrument[6];
        instruments[0] = new StringedInstrument("Скрипка", 4, true);
        instruments[1] = new PercussionInstrument("Барбаны",
                PercussionInstrument.TypePercussionInstrument.WEBBED, false);
        instruments[2] = new WindInstrument("Труба",
                WindInstrument.TypeWindInstrument.COPPER, true);
        instruments[3] = new WindInstrument("Флейта",
                WindInstrument.TypeWindInstrument.WOODEN, false);
        instruments[4] = new StringedInstrument("Гитара", 6, false);
        instruments[5] = new PercussionInstrument("Треугольник",
                PercussionInstrument.TypePercussionInstrument.SMOOTHSOUNDING, true);

        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument);
            System.out.println("Настройка инструментов перед выступлением: ");

            if (instrument instanceof StringedInstrument strInstrument) {
                System.out.println( "Количество струн: " +
                        strInstrument.getStringCount());
            }
            if (instrument instanceof WindInstrument windInstrument) {
                if (windInstrument.getType() == WindInstrument.TypeWindInstrument.WOODEN){
                    System.out.println( "Тип духового инструмента: деревянный");
                }
                if (windInstrument.getType() == WindInstrument.TypeWindInstrument.COPPER){
                    System.out.println( "Тип духового инструмента: медный");
                }

            }
            if (instrument instanceof PercussionInstrument percussInstrument) {
                if (percussInstrument.getType() ==
                        PercussionInstrument.TypePercussionInstrument.SMOOTHSOUNDING) {
                    System.out.println( "Тип ударного инструмента: самозвучащий");
                }
                if (percussInstrument.getType() ==
                        PercussionInstrument.TypePercussionInstrument.WEBBED) {
                    System.out.println( "Тип ударного инструмента: перепончатый");
                }
                if (percussInstrument.getType() ==
                        PercussionInstrument.TypePercussionInstrument.PLASTIC) {
                    System.out.println( "Тип ударного инструмента: пластичный");
                }
            }

            instrument.tune();
            instrument.play();
        }
    }
}