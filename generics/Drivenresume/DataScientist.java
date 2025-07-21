public class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluate() {
        System.out.println("📊 Data Scientist - " + candidateName + " | Experience: " + experienceYears +
                " years | Evaluation: Statistics, ML Models, Data Wrangling");
    }
}
