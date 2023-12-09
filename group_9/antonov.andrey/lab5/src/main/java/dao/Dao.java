package dao;


public interface Dao<K, E> {

    /**
     * CREATE из CRUD
     *
     * @param entity сущность, подлежащяя сохранению
     * @return заглушка, в боевых условиях обычно id сгенерированной сущности
     */
    String save(E entity);

    /**
     * READ из CRUD
     *
     * @param id уникальный идентификатор сущности, подлежащей удалению
     * @return заглушка, в боевых условиях Optional<E>
     */
    String findById(K id);

    /**
     * READ из CRUD
     *
     * @return заглушка, в боевых условиях List<E>
     */
    String findAll();

    /**
     * UPDATE из CRUD
     *
     * @return заглушка, в боевых условиях void()
     */
    String update(E entity);

    /**
     * DELETE из CRUD
     *
     * @param id уникальный идентификатор сущности, подлежащей удалению
     * @return заглушка, в боевых условиях boolean
     */
    String delete(K id);
}
