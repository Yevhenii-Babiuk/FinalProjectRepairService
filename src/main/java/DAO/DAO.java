package DAO;

import java.util.List;

public interface DAO <E, K>{
    void add (E entity);
    List<E> getAll();
    E getEntityByKey(K id);
    void update(E entity);
    void delete (E entity);
}
