package ru.itis.services;

import ru.itis.dao.HumansDao;
import ru.itis.models.Human;

import java.util.List;

/**
 * 09.10.2017
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServiceImpl implements UsersService {

    private HumansDao humansDao;

    public UsersServiceImpl(HumansDao humansDao) {
        this.humansDao = humansDao;
    }

    @Override
    public List<Human> getAllUsers() {
        return humansDao.findAll();
    }

    @Override
    public void addUser(Human human) {
        humansDao.save(human);
    }
}
