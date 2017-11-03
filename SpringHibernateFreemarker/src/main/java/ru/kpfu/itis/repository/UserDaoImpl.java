package ru.kpfu.itis.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 27.10.2017
 *
 * @author Kuznetsov Maxim
 * @version v1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByLogin(String login) {
        User user;
        try {
            user = entityManager.createQuery("from User user where login = :login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    @Override
    @Transactional
    public void save(User model) {
        entityManager.persist(model);
    }

    @Override
    public User find(Long id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public void update(User model) {
        entityManager.merge(model);
    }

    @Override
    @Transactional
    public void delete(User model) {
        entityManager.remove(
                entityManager.contains(model) ? model : entityManager.merge(model)
        );
    }
}
