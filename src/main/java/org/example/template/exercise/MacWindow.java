package org.example.template.exercise;

public class MacWindow extends Window {
    @Override
    protected void executeAfter() {
        System.out.println("close mac programs");
    }

    @Override
    protected void executeBefore() {
        System.out.println("clear garbage");
    }
}
