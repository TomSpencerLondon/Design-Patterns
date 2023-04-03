package org.example.template.exercise;

public abstract class Window {
    public void close() {
        executeBefore();

        System.out.println("Removing the window from the screen");

        executeAfter();
    }

    protected abstract void executeAfter();

    protected abstract void executeBefore();
}