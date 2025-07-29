import java.util.*;

class Appointment {
    private String patientName;
    private String doctorName;
    private String timeSlot;

    public Appointment(String patientName, String doctorName, String timeSlot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Time: " + timeSlot;
    }
}

class AppointmentQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public void addAppointment(T appointment) {
        queue.offer(appointment);
    }

    public T serveNext() {
        return queue.poll();
    }

    public T viewNext() {
        return queue.peek();
    }

    public void displayAll() {
        for (T appointment : queue) {
            System.out.println(appointment);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class HospitalAppointmentSystem {
    public static void main(String[] args) {
        AppointmentQueue<Appointment> doctorAppointments = new AppointmentQueue<>();

        doctorAppointments.addAppointment(new Appointment("John Doe", "Dr. Smith", "10:00 AM"));
        doctorAppointments.addAppointment(new Appointment("Jane Roe", "Dr. Smith", "10:15 AM"));
        doctorAppointments.addAppointment(new Appointment("Alice Lee", "Dr. Adams", "10:30 AM"));

        System.out.println("All Appointments:");
        doctorAppointments.displayAll();

        System.out.println("\nNext Appointment:");
        System.out.println(doctorAppointments.viewNext());

        System.out.println("\nServing Appointment:");
        System.out.println(doctorAppointments.serveNext());

        System.out.println("\nRemaining Appointments:");
        doctorAppointments.displayAll();
    }
}
