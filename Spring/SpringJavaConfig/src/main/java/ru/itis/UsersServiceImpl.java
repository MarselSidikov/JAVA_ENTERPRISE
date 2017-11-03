package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 03.11.2017
 * ru.UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void add(String name) {
        usersRepository.save(name);
    }
}
