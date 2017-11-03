package ru.itis;

/**
 * 03.11.2017
 * ru.itis.UsersRepositoryFakeImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryFakeImpl implements UsersRepository {
    public void save(String name) {
        System.out.println(name + " saved");
    }
}
