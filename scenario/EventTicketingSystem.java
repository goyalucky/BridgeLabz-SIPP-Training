import java.util.*;

class Attendee {
    String name;
    int age;
    String email;

    Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "N/A";
    }

    Attendee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

public class EventTicketingSystem {
    HashMap<String, Queue<Attendee>> eventQueues = new HashMap<>();

    void addBooking(String eventName, Attendee attendee) {
        eventQueues.putIfAbsent(eventName, new LinkedList<>());
        eventQueues.get(eventName).add(attendee);
        System.out.println(attendee.name + " booked for " + eventName);
    }

    int getPosition(String eventName, String attendeeName) {
        Queue<Attendee> queue = eventQueues.get(eventName);
        if (queue == null) return -1;

        int pos = 1;
        for (Attendee a : queue) {
            if (a.name.equalsIgnoreCase(attendeeName)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    public static void main(String[] args) {
        EventTicketingSystem system = new EventTicketingSystem();

        Attendee a1 = new Attendee("Alice", 22);
        Attendee a2 = new Attendee("Bob", 25, "bob@example.com");
        Attendee a3 = new Attendee("Charlie", 30);

        system.addBooking("Rock Concert", a1);
        system.addBooking("Rock Concert", a2);
        system.addBooking("Rock Concert", a3);

        int position = system.getPosition("Rock Concert", "Bob");
        if (position != -1)
            System.out.println("Bob's position in queue: " + position);
        else
            System.out.println("Bob not found in queue.");
    }
}

