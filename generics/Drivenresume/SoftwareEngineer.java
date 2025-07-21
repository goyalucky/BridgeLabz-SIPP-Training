public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluate() {
        System.out.println("🧑‍💻 Software Engineer - " + candidateName + " | Experience: " + experienceYears +
                " years | Evaluation: Coding skills, DSA, System Design");
    }
}
