package org.example.memento;

public class Main {

    public static void main(String[] args) {
        var editor = new Editor();

        editor.setContent("a");
        editor.setContent("b");
        editor.setContent("c");

        editor.undo();

        System.out.println(editor.getContent());
    }
}
