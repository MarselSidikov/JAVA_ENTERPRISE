package ru.itis.jmx.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 05.09.2018
 * SpringCacheImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class SpringCacheImpl implements SpringCache {
    private List<String> cache;
    private int size;

    public SpringCacheImpl() {
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
