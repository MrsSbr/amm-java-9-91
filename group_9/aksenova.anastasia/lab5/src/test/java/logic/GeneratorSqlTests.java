package logic;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import data.PhilosopherTestsData;

public class GeneratorSqlTests {

    @Test
    public void generatorSelectQueryTest() {
        //given
        String expectedSelectQuery = "SELECT id, philosopherName, workName, genre, yearOfCreation, rating FROM \"Philosopher\"";

        //when
        String actualSelectQuery = GeneratorSql.getSelectQuery(PhilosopherTestsData.NIETZSCHE.getClass());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
    @Test
    public void generatorInsertQueryTest() {
        //given
        String expectedInsertQuery = "INSERT INTO \"Philosopher\" VALUES (2, 'Аристотель', 'Большая этика', 'философия', 322, 9.2)";

        //when
        String actualInsertQuery = GeneratorSql.getInsertQuery(PhilosopherTestsData.ARISTOTLE);

        //then
        assertEquals(expectedInsertQuery, actualInsertQuery);
    }

    @Test
    public void generatorUpdateQueryTest() {
        //given
        String expectedUpdateQuery = "UPDATE \"Philosopher\" SET philosopherName = 'Иммануил Кант', workName = 'Критика чистого разума', genre = 'философия и психология', yearOfCreation = 1750, rating = 9.4 WHERE id = 3";

        //when
        String actualUpdateQuery = GeneratorSql.getUpdateQuery(PhilosopherTestsData.KANT);

        //then
        assertEquals(expectedUpdateQuery, actualUpdateQuery);
    }

    @Test
    public void generatorDeleteQueryTest() {
        //given
        String expectedDeleteQuery = "DELETE FROM \"Philosopher\" WHERE id = 1";

        //when
        String actualDeleteQuery = GeneratorSql.getDeleteQuery(PhilosopherTestsData.NIETZSCHE);

        //then
        assertEquals(expectedDeleteQuery, actualDeleteQuery);
    }

}

