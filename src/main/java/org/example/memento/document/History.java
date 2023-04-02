package org.example.memento.document;

import org.example.memento.solution.EditorState;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<DocumentState> states = new ArrayList<>();

    public void push(DocumentState state) {
        states.add(state);
    }

    public DocumentState pop() {
        var lastIndex = states.size() - 1;
        var lastState = states.get(lastIndex);
        states.remove(lastState);

        return lastState;
    }
}
