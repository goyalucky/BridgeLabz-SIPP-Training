interface EventManager {
    void addEvent(Event event);
    void removeEvent(String eventName);
}

class Event {
    String name;
    String date;

    Event(String name, String date) {
        this.name = name;
        this.date = date;
    }

    void showDetails() {
        System.out.println("Event: " + name + ", Date: " + date);
    }
}

class Ticket {
    String userName;
    String eventName;

    Ticket(String userName, String eventName) {
        this.userName = userName;
        this.eventName = eventName;
    }

    void printTicket() {
        System.out.println("Ticket for " + userName + " to attend " + eventName);
    }
}

class User {
    String name;

    User(String name) {
        this.name = name;
    }

    Ticket register(Event event) {
        System.out.println(name + " is registering for " + event.name);
        return new Ticket(name, event.name);
    }
}

class Admin implements EventManager {
    @Override
    public void addEvent(Event event) {
        System.out.println("Admin added event: " + event.name);
    }

    @Override
    public void removeEvent(String eventName) {
        System.out.println("Admin removed event: " + eventName);
    }
}

public class EventHiveApp {
    public static void main(String[] args) {
        Event e1 = new Event("AI Workshop", "2025-08-10");
        User u1 = new User("Prashant");

        e1.showDetails();
        Ticket t1 = u1.register(e1);
        t1.printTicket();

        Admin admin = new Admin();
        admin.addEvent(e1);
        admin.removeEvent("AI Workshop");
    }
}
