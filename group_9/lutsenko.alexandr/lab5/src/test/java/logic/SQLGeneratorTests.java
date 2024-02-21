package logic;

import data.TestsData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SQLGeneratorTests {

    @Test
    public void generateSelectQuery() {
        //given
        String expectedSelectQuery = "SELECT ID, FIO, SCHOLARSHIP, COURSE, GROUP FROM \"СТУДЕНТЫ\";";

        //when
        String actualSelectQuery = null;
        try {
            actualSelectQuery = SQLGenerator.getSelectQuery(TestsData.SASHA_STUDENT);
        } catch (TableException e) {
            fail(e.toString());
        }

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void generateInsertQueryTest() {
        // given
        String expectedInsertQuery = "INSERT INTO \"СТУДЕНТЫ\"(ID, FIO, SCHOLARSHIP, COURSE, GROUP) VALUES(0, 'Луценко Александр Сергеевич', 0, 3, 9);";

        //when
        String actualInsertQuery = null;
        try {
            actualInsertQuery = SQLGenerator.getInsertQuery(TestsData.SASHA_STUDENT);
        } catch (TableException e) {
            fail(e.toString());
        }

        //then
        assertEquals(expectedInsertQuery, actualInsertQuery);
    }

    @Test
    public void generateUpdateQueryTest() {
        // given
        String expectedUpdateQuery = "UPDATE \"СТУДЕНТЫ\" SET FIO = 'Луценко Александр Сергеевич', SCHOLARSHIP = 0, COURSE = 3, GROUP = 9 WHERE ID = 0;";

        //when
        String actualUpdateQuery = null;
        try {
            actualUpdateQuery = SQLGenerator.getUpdateQuery(TestsData.SASHA_STUDENT);
        } catch (TableException e) {
            fail(e.toString());
        }

        //then
        assertEquals(expectedUpdateQuery, actualUpdateQuery);
    }

    @Test
    public void generateDeleteQueryTest() {
        //given
        String expectedDeleteQuery = "DELETE FROM \"СТУДЕНТЫ\" WHERE ID = 0;";

        //when
        String actualDeleteQuery = null;
        try {
            actualDeleteQuery = SQLGenerator.getDeleteQuery(TestsData.SASHA_STUDENT);
        } catch (TableException e) {
            fail(e.toString());
        }

        //then
        assertEquals(expectedDeleteQuery, actualDeleteQuery);
    }

    @Test
    void generateInsertQueryWithApostropheInString() {
        //given
        String expectedInsertQuery = "INSERT INTO \"СТУДЕНТЫ\"(ID, FIO, SCHOLARSHIP, COURSE, GROUP) VALUES(1, 'Джим''хек Свиф''т', 3500, 2, 9);";

        //when
        String actualInsertQuery = null;
        try {
            actualInsertQuery = SQLGenerator.getInsertQuery(TestsData.STUDENT_WITH_APOSTROPHE);
        } catch (TableException e) {
            fail(e.toString());
        }

        //then
        assertEquals(expectedInsertQuery, actualInsertQuery);
    }

    @Test
    void generateDeleteQueryForEntityWithManyPrimaryKeysTest() {
        // given
        String expectedDeleteQuery = "DELETE FROM \"ЛЮДИ\" WHERE FIRSTNAME = 'Василий', LASTNAME = 'Иванов';";

        // when
        String actualDeleteQuery = null;
        try {
            actualDeleteQuery = SQLGenerator.getDeleteQuery(TestsData.VASILIY_IVANOV);
        } catch (TableException e) {
            fail(e.toString());
        }

        // then
        assertEquals(expectedDeleteQuery, actualDeleteQuery);
    }
}
