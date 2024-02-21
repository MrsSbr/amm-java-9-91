package dao;

import entity.UserEntity;
import lib.GeneratorSqlQueries;
import lib.GeneratorSqlQueriesImpl;

public class UserDao implements Dao<Long, UserEntity> {

    public static final GeneratorSqlQueries<Long, UserEntity> GENERATOR_SQL_QUERIES =
        new GeneratorSqlQueriesImpl<>(UserEntity.class);

    @Override
    public String save(final UserEntity entity) {
        return GENERATOR_SQL_QUERIES.buildInsertQuery(entity);
    }

    @Override
    public String findById(final Long id) {
        return GENERATOR_SQL_QUERIES.buildSelectByIdQuery(id);
    }

    @Override
    public String findAll() {
        return GENERATOR_SQL_QUERIES.buildSelectAllQuery();
    }

    @Override
    public String update(final UserEntity entity) {
        return GENERATOR_SQL_QUERIES.buildUpdateQuery(entity);
    }

    @Override
    public String delete(final Long id) {
        return GENERATOR_SQL_QUERIES.buildDeleteQuery(id);
    }
}
