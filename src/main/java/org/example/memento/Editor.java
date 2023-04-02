package org.example.memento;

import java.util.ArrayList;
import java.util.List;

public class Editor {

    private List<String> content = new ArrayList<>();
    private int index = -1;

    public String getContent() {
        return content.get(index);
    }

    public void setContent(String content) {
        this.content.add(content);
        index++;
    }

    public void undo() {
        if (index > 0) {
            index--;
        }
    }
}
