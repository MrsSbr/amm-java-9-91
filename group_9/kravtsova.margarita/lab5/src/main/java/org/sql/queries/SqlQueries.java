package org.sql.queries;

import org.sql.queries.cat.Cat;
import org.sql.queries.cat.CatBreeds;
import org.sql.queries.cat.Gender;

public class SqlQueries {
    public static void main(String[] args) {
        SqlQueryGenerator generator = new SqlQueryGenerator();
        System.out.println(generator.generateInsertQueries(
                new Cat(1, "Мира", Gender.FEMALE, 6, CatBreeds.NOT_BREED, false, true)));
        System.out.println();
        System.out.println(generator.generateSelectByPrimaryKeyEntityQuery(Cat.class, 1));
        System.out.println();
        System.out.println(generator.generateSelectAllEntitiesQuery(Cat.class));
        System.out.println();
        System.out.println(generator.generateUpdateEntitiesQuery(
                new Cat(1, "Мира", Gender.FEMALE, 6, CatBreeds.NOT_BREED, false, true)));
        System.out.println();
        System.out.println(generator.generateDeleteByPrimaryKeyEntityQuery(Cat.class, 23));
    }
}