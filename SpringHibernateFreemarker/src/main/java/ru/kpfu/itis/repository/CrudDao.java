package ru.kpfu.itis.repository;

import java.util.List;

/**
 * 27.10.2017
 *
 * @author Kuznetsov Maxim
 * @version v1.0
 */
public interface CrudDao<T, I> {
    void save(T model);
    T find(I id);
    List<T> findAll();
    void update(T model);
    void delete(T model);
}
