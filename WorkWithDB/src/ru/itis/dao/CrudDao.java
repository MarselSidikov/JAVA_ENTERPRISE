package ru.itis.dao;

import java.util.List;

/**
 * 11.09.2017
 * CrudDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CrudDao<M, I> {
    List<M> findAll();
    void save(M model);
    M find(I id);
    void delete(I id);
    void update(M model);
}
