package Service.MusicService.Factory;

import Service.MusicService.User;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class RandomUserFactory {

    private static final List<String> FIRST_NAMES;
    private static final List<String> SECOND_NAMES;
    private static final int COUNT;

    static {
        FIRST_NAMES = List.of(
                "Игорь",
                "Анастасия",
                "Екатерина",
                "Дмитрий",
                "Ольга",
                "Сергей",
                "Татьяна",
                "Андрей",
                "Анна",
                "Михаил",
                "Ирина",
                "Владимир",
                "Мария",
                "Николай",
                "Елена",
                "Алексей",
                "Наталья",
                "Юрий",
                "Светлана",
                "Павел",
                "Виктория",
                "Валентин",
                "Оксана",
                "Василий",
                "Евгения",
                "Григорий",
                "Людмила",
                "Артем",
                "Алёна",
                "Илья",
                "Елизавета",
                "Антон",
                "Нина",
                "Константин",
                "Маргарита",
                "Денис",
                "Юлия",
                "Виктор",
                "Инна",
                "Семен",
                "Вера",
                "Станислав",
                "Дарья",
                "Роман",
                "Лариса",
                "Валерий",
                "София",
                "Геннадий",
                "Ксения"
        );
        SECOND_NAMES = List.of(
                "Кононов",
                "Симакова",
                "Петров",
                "Смирнов",
                "Смирнова",
                "Кузнецов",
                "Васильев",
                "Попов",
                "Соколов",
                "Михайлов",
                "Новиков",
                "Федоров",
                "Морозов",
                "Волков",
                "Алексеев",
                "Лебедев",
                "Семенов",
                "Егоров",
                "Павлов",
                "Козлов",
                "Степанов",
                "Никитин",
                "Орлов",
                "Андреев",
                "Макаров",
                "Николаев",
                "Ковалев",
                "Захаров",
                "Борисов",
                "Кудрявцев",
                "Шишкин",
                "Киселев",
                "Стрелков",
                "Белов",
                "Фомин",
                "Титов",
                "Демидов",
                "Беляев",
                "Медведев",
                "Григорьев",
                "Тихонов",
                "Муравьев",
                "Осипов",
                "Щербаков",
                "Баранов",
                "Сазонов",
                "Гусев",
                "Миронов"
        );
        COUNT = 100;
    }

    public User getUser() {
        CompositionBuilder builder = new CompositionBuilder(COUNT);
        Random random = new Random();

        var first_name = FIRST_NAMES.get(random.nextInt(FIRST_NAMES.size()));
        var second_name = SECOND_NAMES.get(random.nextInt(SECOND_NAMES.size()));
        var compositions = builder.getListOfCompositions();

        return new User(first_name, second_name, compositions);
    }
}
