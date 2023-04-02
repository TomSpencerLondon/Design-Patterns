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