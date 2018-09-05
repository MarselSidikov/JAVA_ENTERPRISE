package ru.itis.jmx.simple;

/**
 * 05.09.2018
 * ru.itis.jxm.simple.StringsCacheMBean
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface StringsCacheMBean {
    int getSize();
    void setSize(int size);

    void printStrings();
    void push(String string);
}
