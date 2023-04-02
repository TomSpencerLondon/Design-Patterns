### Design Patterns

#### Essential Key terms:
- encapsulation
- Abstraction
- Inheritance
- Polymorphism


### Memento Pattern
![image](https://user-images.githubusercontent.com/27693622/229380954-9c451226-e1d2-4dcf-9c10-615bac7507cc.png)

![image](https://user-images.githubusercontent.com/27693622/229381000-122b5a8a-2ee4-4587-841f-546ed70c78c8.png)
In the above example the Editor class has a createState() function which creates a record of the current state of the
Editor which can then be saved in the History class.

```java
public class Editor {

    private String content;

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        content = state.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```
The EditorState is effectively a copy of the Editor class which can then be stored in the History class:
````java
public class EditorState {

    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
````

The History class then plays the role of a stack to record the current requested state:
```java
public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
        var lastIndex = states.size() - 1;
        var lastState = states.get(lastIndex);
        states.remove(lastState);

        return lastState;
    }
}
```
This class returns the current state and removes it from the list and can also receive new states.

Below is another example of the Memento pattern with more attributes:
![image](https://user-images.githubusercontent.com/27693622/229382263-6dbb555c-fa68-46bb-9fc7-530dc1de2bc5.png)

With the memento pattern we therefore have undoable actions on our classes as we are recording earlier states.

### State Pattern
The problem is how do we represent different states on a Canvas object:
```java
public class Canvas {

    private ToolType currentTool;

    public void mouseDown() {
        if (currentTool == ToolType.SELECTION) {
            System.out.println("Selection icon");
        } else if (currentTool == ToolType.BRUSH) {
            System.out.println("Brush icon");
        } else if (currentTool == ToolType.ERASER) {
            System.out.println("Eraser icon");
        }
    }

    public void mouseUp() {
        if (currentTool == ToolType.SELECTION) {
            System.out.println("Draw dashed rectangle");
        } else if (currentTool == ToolType.BRUSH) {
            System.out.println("Draw a line");
        } else if (currentTool == ToolType.ERASER) {
            System.out.println("Eraser something");
        }
    }

    public ToolType getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(ToolType currentTool) {
        this.currentTool = currentTool;
    }
}
```
The above application is difficult to extend. For instance if we want to add a circle tool then we have to
change both methods. We would rather have the method behave differently depending on the current tool.

![image](https://user-images.githubusercontent.com/27693622/229384052-5f3031c4-3896-414e-81b3-9698cef896a6.png)

The main class in the above example above calls the abstract class which behaves differently according to the selected state.

We can apply this technique to our solution for the Canvas tool problem:

![image](https://user-images.githubusercontent.com/27693622/229383972-6ef7244b-d46e-4e71-a032-e9f5dca6fbb3.png)
