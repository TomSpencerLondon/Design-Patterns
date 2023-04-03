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

![image](https://user-images.githubusercontent.com/27693622/229384101-f871fbe5-a535-49c6-9cea-7f2560113c8b.png)

The main class in the above example above calls the abstract class which behaves differently according to the selected state.

We can apply this technique to our solution for the Canvas tool problem:

![image](https://user-images.githubusercontent.com/27693622/229383972-6ef7244b-d46e-4e71-a032-e9f5dca6fbb3.png)

This application of the State pattern allows the object to behave differently depending on its state.

### Abusing Patterns
Design patterns can be powerful but it is important to remember:
```text
Simplicity is the ultimate sophistication
```
Leonardo DaVinci

### Iterator Pattern
Every browser has the concept of history. We want to implement this functionality.

![image](https://user-images.githubusercontent.com/27693622/229511436-bd0ebda8-06e3-4a3d-9813-844fb652d0b6.png)

We then use this code to avoid showing the internal working of the data structure storing urls on the BrowseHistory class.

```java
import org.example.iterator.BrowseHistory;

class Main {
    public static void main(String[] args) {
        BrowseHistory history = new BrowseHistory();
        while (history.hasNext) {
            var current = history.current();
            // print current
            history.next();
        }
    }
}
```
With the above structure we don't know the internal working of the BrowseHistory data structure.
Also we should add the Iterator interface to move the responsibility of iteration from the BrowseHistory class:
![image](https://user-images.githubusercontent.com/27693622/229513017-6594bfd9-8e2a-4d0d-92a2-ac91d0e82e3c.png)

Now we can use the iterator to show each item in the BrowseHistory:

```java
public class Main {
    public static void main(String[] args) {
        BrowseHistory history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        Iterator iterator = history.createIterator();

        while (iterator.hasNext()) {
            String current = (String) iterator.current();
            System.out.println(current);
            iterator.next();
        }
    }
}
```
The Iterator interface:
```java

public interface Iterator<T> {

    boolean hasNext();
    T current();
    void next();
}

```

The implementation of the Iterator interface is now declared inside the BrowseHistory class:
```java
package org.example.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {

    private List<String> urls = new ArrayList<>();

    public void push(String url){
        urls.add(url);
    }

    public String pop() {
        int lastIndex = urls.size() - 1;
        String lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);

        return lastUrl;
    }

    public Iterator createIterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<String> {

        private final BrowseHistory history;
        private int index;

        public ListIterator(BrowseHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return index < history.urls.size();
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }
}

```