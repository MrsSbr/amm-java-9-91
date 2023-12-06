package org.sql.queries;

import org.junit.jupiter.api.Test;
import org.sql.queries.cat.Cat;
import org.sql.queries.cat.CatBreeds;
import org.sql.queries.cat.Gender;

import static org.junit.jupiter.api.Assertions.*;

class SqlQueryGeneratorTest {
    private final SqlQueryGenerator generator = new SqlQueryGenerator();
    @Test
    void generateInsertQueries() {
        Cat barsic = new Cat(2,"Барсик", Gender.MALE,1, CatBreeds.BRITISH,true,true);
        String expectedResult = "INSERT INTO Cats (name, gender, age, breed, fertility, hasMaster)\n" +
                "VALUES (Барсик, MALE, 1, BRITISH, true, true);";
        assertEquals(expectedResult,generator.generateInsertQueries(barsic));
    }
    @Test
    void generateSelectAllEntitiesQuery() {
        String expectedResult = "SELECT *\nFROM Cats;";
        assertEquals(expectedResult,generator.generateSelectAllEntitiesQuery(Cat.class));
    }
    @Test
    void generateSelectByPrimaryKeyEntityQuery() {
        String expectedResult = "SELECT *\nFROM Cats\nWHERE idCat = 15;";
        assertEquals(expectedResult,generator.generateSelectByPrimaryKeyEntityQuery(Cat.class, 15));
    }
    @Test
    void generateUpdateEntitiesQuery() {
        Cat mira = new Cat(1,"Мира",Gender.FEMALE,6,CatBreeds.NOT_BREED, false, true);
        String expectedResult = "UPDATE Cats\nSET name = Мира, gender = FEMALE, " +
                "age = 6, breed = NOT_BREED, fertility = false, " +
                "hasMaster = true\nWHERE idCat = 1;";
        assertEquals(expectedResult,generator.generateUpdateEntitiesQuery(mira));
    }
    @Test
    void generateDeleteByPrimaryKeyEntityQuery() {
        String expectedResult = "DELETE from Cats\nWHERE idCat = 62;";
        assertEquals(expectedResult,generator.generateDeleteByPrimaryKeyEntityQuery(Cat.class, 62));
    }
    @Test
    void generateInsertQueriesEmptyEntity() {
        String expectedResult = "INSERT INTO Cats (name, gender, age, breed, fertility, hasMaster)\n" +
                "VALUES (NULL, NULL, NULL, NULL, NULL, NULL);";
        Cat emptyCat = new Cat(null,null,null,null,null,null,null);
        assertEquals(expectedResult, generator.generateInsertQueries(emptyCat));
    }
    @Test
    void generateSelectAllEntitiesQueryNullClass() {
        assertThrows(RuntimeException.class,()->generator.generateSelectAllEntitiesQuery(null));
    }
    @Test
    void generateSelectByPrimaryKeyEntityQueryNullClass() {
        assertThrows(RuntimeException.class,()->generator.generateSelectByPrimaryKeyEntityQuery(null, 15));
    }
    @Test
    void generateUpdateEntitiesQueryEmptyEntity() {
        Cat emptyCat = new Cat(null,null,null,null,null,null,null);
        assertThrows(RuntimeException.class,()->generator.generateUpdateEntitiesQuery(emptyCat));
    }
    @Test
    void generateDeleteByPrimaryKeyEntityQueryNullClass() {
        assertThrows(RuntimeException.class,()->generator.generateDeleteByPrimaryKeyEntityQuery(null, 62));
    }
}