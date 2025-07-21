public class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println("Research-Based Course: " + courseName + " | Credits: " + credits + " | Evaluation: Research Paper + Viva");
    }
}
