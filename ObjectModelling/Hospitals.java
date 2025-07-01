package ObjectModelling;

import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting " + patient.name);
    }
}

class Hospital {
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    void addDoctor(Doctor doc) {
        doctors.add(doc);
    }

    void addPatient(Patient pat) {
        patients.add(pat);
    }
}

public class Hospitals {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Doctor d1 = new Doctor("Sharma");
        Doctor d2 = new Doctor("Kumar");

        Patient p1 = new Patient("Ravi");
        Patient p2 = new Patient("Sita");

        hospital.addDoctor(d1);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d2.consult(p2);
    }
}
