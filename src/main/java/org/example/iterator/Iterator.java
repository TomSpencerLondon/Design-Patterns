package org.example.iterator;

public interface Iterator<T> {

    boolean hasNext();
    T current();
    void next();
}
