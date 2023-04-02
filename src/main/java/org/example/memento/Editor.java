package org.example.memento;

import java.util.ArrayList;
import java.util.List;

public class Editor {

    private List<String> contents = new ArrayList<>();
    private int index = -1;

    public String getContent() {
        return contents.get(index);
    }

    public void setContent(String contents) {
        this.contents.add(contents);
        index++;
    }

    public void undo() {
        if (index > 0) {
            index--;
        }
    }
}
