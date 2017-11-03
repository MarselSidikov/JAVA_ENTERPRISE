package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 03.11.2017
 * ru.itis.Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");
        UsersService usersService = context.getBean(UsersService.class);
        usersService.add("Marsel");

        Human h1 = context.getBean(Human.class);
        h1.setName("Marsel");

        Human h2 = context.getBean(Human.class);
        System.out.println(h2.getName());
    }
}
