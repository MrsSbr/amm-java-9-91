package lib;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Entity.CarEntityTest;
import Entity.UserEntityTest;
import entity.Gender;
import org.junit.jupiter.api.Test;

class GeneratorSqlQueriesImplTest {

    @Test
    void shouldBuildInsertQueryWithoutNull() {
        final var userEntity = UserEntityTest.builder().id(5).age(20).name("user").email("test@email").phone("11222333")
            .birthday(LocalDate.of(2023, 11, 12)).adult(true).gender(Gender.MALE).carId(10)
            .carEntityTest(new CarEntityTest())
            .build();

        String expectedResult = """
            INSERT INTO public.users (adult, age, birthday, carId, email, gender, id, name, phone)
            VALUES (true, 20, '2023-11-12', 10, 'test@email', 'MALE', 5, 'user', '11222333');
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Long, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildInsertQuery(userEntity));
    }

    @Test
    void shouldBuildInsertQueryWithNull() {
        final var userEntity =
            UserEntityTest.builder().id(5).age(20).name("user").email("test@email").phone(null).birthday(null)
                .adult(true).gender(null).carId(10).carEntityTest(new CarEntityTest()).build();

        String expectedResult = """
            INSERT INTO public.users (adult, age, birthday, carId, email, gender, id, name, phone)
            VALUES (true, 20, null, 10, 'test@email', null, 5, 'user', null);
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Long, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildInsertQuery(userEntity));
    }

    @Test
    void shouldBuildInsertQueryWithMissingValues() {
        final var userEntity = UserEntityTest.builder()
            .id(5)
            .name("User")
            .build();

        String expectedResult = """
            INSERT INTO public.users (adult, age, birthday, carId, email, gender, id, name, phone)
            VALUES (null, 0, null, 0, null, null, 5, 'User', null);
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Long, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildInsertQuery(userEntity));
    }


    @Test
    void shouldBuildSelectByIdQuery() {
        String expectedResult = """
            SELECT adult, age, birthday, carId, email, gender, id, name, phone
            FROM public.users
            WHERE id = 5;
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Integer, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildSelectByIdQuery(5));
    }


    @Test
    void shouldBuildSelectAllQuery() {
        String expectedResult = """
            SELECT adult, age, birthday, carId, email, gender, id, name, phone
            FROM public.users;
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Integer, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildSelectAllQuery());
    }

    @Test
    void shouldBuildUpdateQueryWithoutNull() {
        final var userEntity = UserEntityTest.builder().id(5).age(20).name("user").email("test@email").phone("11222333")
            .birthday(LocalDate.of(2023, 11, 12)).adult(true).gender(Gender.MALE).carId(10)
            .carEntityTest(new CarEntityTest())
            .build();
        String expectedResult = """
            UPDATE public.users
            SET birthday = '2023-11-12', gender = 'MALE', phone = '11222333', name = 'user', id = 5, adult = true, email = 'test@email', age = 20, carId = 10
            WHERE id = 5;
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Integer, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildUpdateQuery(userEntity));
    }

    @Test
    void shouldBuildUpdateQueryWithNull() {
        final var userEntity =
            UserEntityTest.builder().id(5).age(20).name("user").email("test@email").phone(null).birthday(null)
                .adult(true).gender(null).carId(10).carEntityTest(new CarEntityTest()).build();

        String expectedResult = """
            UPDATE public.users
            SET birthday = null, gender = null, phone = null, name = 'user', id = 5, adult = true, email = 'test@email', age = 20, carId = 10
            WHERE id = 5;          
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Integer, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildUpdateQuery(userEntity));
    }


    @Test
    void shouldBuildUpdateQueryWithMissing() {
        final var userEntity = UserEntityTest.builder()
            .id(5)
            .age(20)
            .carEntityTest(new CarEntityTest()).build();

        String expectedResult = """
            UPDATE public.users
            SET birthday = null, gender = null, phone = null, name = null, id = 5, adult = null, email = null, age = 20, carId = 0
            WHERE id = 5;                              
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Integer, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildUpdateQuery(userEntity));
    }


    @Test
    void shouldBuildDeleteQuery() {
        String expectedResult = """
            DELETE FROM public.users
            WHERE id = 3;
            """;
        final var generatorSqlQueries = new GeneratorSqlQueriesImpl<Integer, UserEntityTest>(UserEntityTest.class);
        assertEquals(expectedResult, generatorSqlQueries.buildDeleteQuery(3));
    }
}