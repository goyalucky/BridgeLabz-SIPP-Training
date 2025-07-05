package LinkedList.Circularlinkedlist;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    Task head = null;
    Task tail = null;
    Task currentTask = null;

    void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            currentTask = head;
            return;
        }
        newTask.next = head;
        head = newTask;
        tail.next = head;
    }

    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            currentTask = head;
            return;
        }
        tail.next = newTask;
        tail = newTask;
        tail.next = head;
    }

    void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        if (head.taskId == taskId) {
            if (head == tail) {
                head = tail = null;
                currentTask = null;
            } else {
                head = head.next;
                tail.next = head;
                if (currentTask.taskId == taskId) currentTask = head;
            }
            System.out.println("Task removed.");
            return;
        }
        Task temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Task not found.");
        } else {
            if (temp.next == tail) {
                tail = temp;
            }
            if (currentTask.taskId == taskId) currentTask = currentTask.next;
            temp.next = temp.next.next;
            System.out.println("Task removed.");
        }
    }

    void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        printTask(currentTask);
        currentTask = currentTask.next;
    }

    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority " + priority);
    }

    void printTask(Task t) {
        System.out.println("Task ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due Date: " + t.dueDate);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();

        scheduler.addAtEnd(1, "Complete Java Assignment", 2, "2025-07-10");
        scheduler.addAtBeginning(2, "Prepare for Test", 1, "2025-07-08");
        scheduler.addAtEnd(3, "Project Presentation", 3, "2025-07-12");
        scheduler.addAtPosition(2, 4, "Team Meeting", 2, "2025-07-09");

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nViewing Next Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nSearching Tasks with Priority 2:");
        scheduler.searchByPriority(2);

        System.out.println("\nRemoving Task with ID 3:");
        scheduler.removeByTaskId(3);

        System.out.println("\nFinal Task List:");
        scheduler.displayAllTasks();
    }
}
