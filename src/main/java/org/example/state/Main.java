package org.example.state;

public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.setCurrentState(ToolType.BRUSH);

        canvas.mouseUp();
        canvas.mouseDown();

        canvas.setCurrentState(ToolType.ERASER);
        canvas.mouseUp();
        canvas.mouseDown();
    }
}
