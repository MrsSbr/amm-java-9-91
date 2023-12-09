package lib;

public interface GeneratorSqlQueries<K, E> {
    /**
     * Формирование SQL запроса при добавлении в базу данных
     * @param entity экземпляр сущности, данные которой нужно вставить
     * @return сформированный SQL запрос, готовый к отправлению в БД
     */
    String buildInsertQuery(final E entity);

    /**
     * Формирование SQL запроса при поиске данных по id
     * @param id уникальный идентификатор сущности
     * @return сформированный SQL запрос, готовый к отправлению в БД
     */
    String buildSelectByIdQuery(final K id);

    /**
     * Формирование SQL запроса при поиске всех данных
     * @return сформированный SQL запрос, готовый к отправлению в БД
     */
    String buildSelectAllQuery();

    /**
     * Формирование SQL запроса при обновлении данных сущности
     * @param entity cущность, поля которой нужно изменить
     * @return сформированный SQL запрос, готовый к отправлению в БД
     */
    String buildUpdateQuery(final E entity);

    /**
     * Формирование SQL запроса при удалении данных о сущности
     * @param id уникальный идентификатор сущности
     * @return сформированный SQL запрос, готовый к отправлению в БД
     */
    String buildDeleteQuery(final K id);
}
