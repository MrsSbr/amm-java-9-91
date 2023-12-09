import java.time.LocalDateTime;
import dao.CarDao;
import dao.Dao;
import dao.UserDao;
import entity.Brand;
import entity.CarEntity;
import entity.Color;
import entity.UserEntity;

public class SqlGeneratorRunner {
    public static void main(String[] args) {

        final Dao<Long, UserEntity> userDao = new UserDao();
        final Dao<Integer, CarEntity> carDao = new CarDao();

        final var user = UserEntity.builder()
            .id(5L)
            .name("user")
            .email("test@email")
            .phone("11222333")
            .birthday(LocalDateTime.now())
            .adult(null)
            .build();

        final var carEntity = CarEntity.builder()
            .id(10)
            .brand(Brand.BMW)
            .color(Color.BLACK)
            .seatsQuantity(4)
            .carCategoryId(2)
            .userId(null)
            .image("image.png")
            .build();

        testSqlGenerator(user, user.getId(), userDao);
        testSqlGenerator(carEntity, carEntity.getId(), carDao);
    }

    private static <K, E> void testSqlGenerator(E entity, K key, Dao<K, E> dao) {
        System.out.println(
            "------------------------------------------------------------------------------------------");
        System.out.println(dao.save(entity));
        System.out.println(dao.findById(key));
        System.out.println(dao.findAll());
        System.out.println(dao.update(entity));
        System.out.println(dao.delete(key));
        System.out.println(
            "------------------------------------------------------------------------------------------");
    }
}
