package dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Base interface for all DAO layer
 * @param <E>
 * @param <K>
 */
public interface DAO <E, K>{
    public void add(E entity) throws SQLException;
    public List<E> getAll() throws SQLException;
    public E getEntityByKey(K id);
    public void update(E entity);
    public void delete(E entity);
}
