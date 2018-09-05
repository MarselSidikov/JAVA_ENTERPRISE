package ru.itis.jmx.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 05.09.2018
 * StringsCache
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class StringsCache implements StringsCacheMBean {

    private List<String> cache;
    private int size;

    public StringsCache() {
        cache = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void printStrings() {
        cache.forEach(System.out::print);
    }

    public void push(String string) {
        if (cache.size() < size) {
            cache.add(string);
        } else {
            System.err.println("Out of memory");
        }
    }
}
