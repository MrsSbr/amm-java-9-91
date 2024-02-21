package dao;

import entity.CarEntity;
import lib.GeneratorSqlQueries;
import lib.GeneratorSqlQueriesImpl;

public class CarDao implements Dao<Integer, CarEntity> {

    public static final GeneratorSqlQueries<Integer, CarEntity> GENERATOR_SQL_QUERIES =
        new GeneratorSqlQueriesImpl<>(CarEntity.class);

    @Override
    public String save(final CarEntity entity) {
        return GENERATOR_SQL_QUERIES.buildInsertQuery(entity);
    }

    @Override
    public String findById(final Integer id) {
        return GENERATOR_SQL_QUERIES.buildSelectByIdQuery(id);
    }

    @Override
    public String findAll() {
        return GENERATOR_SQL_QUERIES.buildSelectAllQuery();
    }

    @Override
    public String update(final CarEntity entity) {
        return GENERATOR_SQL_QUERIES.buildUpdateQuery(entity);
    }

    @Override
    public String delete(final Integer id) {
        return GENERATOR_SQL_QUERIES.buildDeleteQuery(id);
    }
}
