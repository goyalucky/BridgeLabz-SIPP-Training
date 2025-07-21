public class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluate() {
        System.out.println("📦 Product Manager - " + candidateName + " | Experience: " + experienceYears +
                " years | Evaluation: Strategy, Communication, Roadmapping");
    }
}
