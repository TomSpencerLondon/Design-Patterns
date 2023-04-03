package org.example.iterator;

public class Main {
    public static void main(String[] args) {
        BrowseHistory history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        Iterator iterator = history.createIterator();

        while (iterator.hasNext()) {
            String current = (String) iterator.current();
            System.out.println(current);
            iterator.next();
        }
    }
}
