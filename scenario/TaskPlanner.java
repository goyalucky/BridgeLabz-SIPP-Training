import java.util.LinkedList;
import java.util.Scanner;

abstract class Task {
    String description;

    Task(String description) {
        this.description = description;
    }

    abstract void execute();
}

class Meeting extends Task {
    Meeting(String description) {
        super(description);
    }

    @Override
    void execute() {
        System.out.println("Joining meeting: " + description);
    }
}

class Workout extends Task {
    Workout(String description) {
        super(description);
    }

    @Override
    void execute() {
        System.out.println("Starting workout: " + description);
    }
}

class CodingSession extends Task {
    CodingSession(String description) {
        super(description);
    }

    @Override
    void execute() {
        System.out.println("Starting coding session: " + description);
    }
}

public class TaskPlanner {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();
        tasks.add(new Meeting("Team sync at 10 AM"));
        tasks.add(new Workout("Morning cardio"));
        tasks.add(new CodingSession("Build login module"));

        for (Task t : tasks) {
            t.execute();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();

        boolean found = false;
        for (Task t : tasks) {
            if (t.description.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + t.description);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No task found with keyword: " + keyword);
        }
    }
}
