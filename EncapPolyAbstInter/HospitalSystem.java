package EncapPolyAbstInter;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private int daysAdmitted;
    private String record;

    public InPatient(String patientId, String name, int age, double roomCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return roomCharge * daysAdmitted;
    }

    public void addRecord(String record) {
        this.record = record;
    }

    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String record;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        this.record = record;
    }

    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient[] patients = new Patient[3];
        patients[0] = new InPatient("P101", "Amit", 35, 2500, 4);
        patients[1] = new OutPatient("P102", "Riya", 29, 800);
        patients[2] = new InPatient("P103", "Soham", 40, 3000, 3);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: ₹" + p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord rec = (MedicalRecord) p;
                rec.addRecord("Initial checkup complete.");
                rec.viewRecords();
            }
        }
    }
}
