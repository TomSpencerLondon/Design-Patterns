package org.example.iterator.exercise;

public interface Iterator<T> {
    boolean hasNext();
    T current();

    void next();
}
