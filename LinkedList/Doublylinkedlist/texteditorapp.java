package LinkedList.Doublylinkedlist;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    TextState head, current;
    int historyLimit = 10;
    int historyCount = 0;

    void addNewState(String newContent) {
        TextState newState = new TextState(newContent);

        if (head == null) {
            head = current = newState;
            historyCount = 1;
            return;
        }

        current.next = null;

        newState.prev = current;
        current.next = newState;
        current = newState;

        historyCount++;
        if (historyCount > historyLimit) {
            head = head.next;
            head.prev = null;
            historyCount--;
        }
    }

    void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed.");
    }

    void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed.");
    }

    void displayCurrentState() {
        if (current == null) {
            System.out.println("No text content.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    void displayHistory() {
        System.out.println("History (from oldest to newest):");
        TextState temp = head;
        while (temp != null) {
            System.out.println("- " + temp.content);
            temp = temp.next;
        }
    }
}

public class texteditorapp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addNewState("Hello");
        editor.addNewState("Hello World");
        editor.addNewState("Hello World!");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addNewState("New sentence after undo");
        editor.displayCurrentState();

        System.out.println("\nFull History:");
        editor.displayHistory();
    }
}
