import java.util.*;

class Reservation {
    private String customerName;
    private int tableNumber;
    private String reservationTime;

    public Reservation(String customerName, int tableNumber, String reservationTime) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.reservationTime = reservationTime;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public int getTableNumber() {
        return tableNumber;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public String toString() {
        return "Customer: " + customerName + ", Table: " + tableNumber + ", Time: " + reservationTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Reservation)) return false;
        Reservation r = (Reservation) obj;
        return this.tableNumber == r.tableNumber && this.reservationTime.equals(r.reservationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, reservationTime);
    }
}

class ReservationSystem<T extends Reservation> {
    private List<T> reservations = new ArrayList<>();
    private Set<T> uniqueReservations = new HashSet<>();

    public boolean addRes(T reservation) {
        if (uniqueReservations.add(reservation)) {
            reservations.add(reservation);
            return true;
        }
        return false;
    }

    public void viewReservations() {
        for (T reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

public class RestaurantReservationApp {
    public static void main(String[] args) {
        ReservationSystem<Reservation> branch1 = new ReservationSystem<>();

        branch1.addRes(new Reservation("Alice", 1, "7:00 PM"));
        branch1.addRes(new Reservation("Bob", 2, "7:30 PM"));
        branch1.addRes(new Reservation("Charlie", 1, "7:00 PM"));
        branch1.addRes(new Reservation("David", 3, "8:00 PM"));

        System.out.println("Upcoming Reservations:");
        branch1.viewReservations();
    }
}
