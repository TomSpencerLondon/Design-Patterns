package org.example.state;

public class Canvas {

    private State currentState;

    public void mouseDown() {
        currentState.mouseDown();
    }

    public void mouseUp() {
        currentState.mouseUp();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ToolType currentTool) {
        if (currentTool == ToolType.SELECTION) {
            this.currentState = new SelectionState();
        } else if (currentTool == ToolType.BRUSH) {
            this.currentState = new BrushState();
        } else if (currentTool == ToolType.ERASER) {
            this.currentState = new EraserState();
        }
    }
}
