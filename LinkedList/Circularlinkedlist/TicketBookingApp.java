package LinkedList.Circularlinkedlist;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null, tail = null;

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully for " + customerName);
    }

    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        Ticket current = head, prev = tail;
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket with ID " + ticketId + " cancelled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID not found.");
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tickets found for customer: " + customerName);
    }

    void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tickets found for movie: " + movieName);
    }

    int countTotalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    void printTicket(Ticket t) {
        System.out.println("Ticket ID: " + t.ticketId + ", Customer: " + t.customerName + ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Alice", "Inception", "A1", "18:00");
        system.addTicket(2, "Bob", "Interstellar", "B2", "20:00");
        system.addTicket(3, "Charlie", "Inception", "A2", "18:00");

        System.out.println("\nAll Booked Tickets:");
        system.displayTickets();

        System.out.println("\nSearch tickets by customer 'Alice':");
        system.searchByCustomerName("Alice");

        System.out.println("\nSearch tickets for movie 'Inception':");
        system.searchByMovieName("Inception");

        System.out.println("\nTotal number of booked tickets: " + system.countTotalTickets());

        System.out.println("\nCancelling Ticket ID 2:");
        system.removeTicket(2);

        System.out.println("\nRemaining Tickets:");
        system.displayTickets();

        System.out.println("\nTotal number of booked tickets now: " + system.countTotalTickets());
    }
}
