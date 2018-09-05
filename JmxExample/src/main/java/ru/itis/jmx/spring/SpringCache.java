package ru.itis.jmx.spring;

/**
 * 05.09.2018
 * SpringCache
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface SpringCache {
    int getSize();
    void setSize(int size);

    void printStrings();
    void push(String string);
}
