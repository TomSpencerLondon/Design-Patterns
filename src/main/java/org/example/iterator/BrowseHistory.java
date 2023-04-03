package org.example.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {

    private String[] urls = new String[10];
    private int index;

    public BrowseHistory() {
        index = 0;
    }

    public void push(String url){
        urls[index++] = url;
    }

    public String pop() {
        int lastIndex = urls.length - 1;
        String lastUrl = urls[lastIndex];
        urls[lastIndex] = null;

        return lastUrl;
    }

    public Iterator createIterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<String> {

        private final BrowseHistory history;
        private int index;

        public ListIterator(BrowseHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return index < history.urls.length && history.urls[index] != null;
        }

        @Override
        public String current() {
            return history.urls[index];
        }

        @Override
        public void next() {
            index++;
        }
    }
}
