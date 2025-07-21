public class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println("Assignment-Based Course: " + courseName + " | Credits: " + credits + " | Evaluation: Weekly Assignments");
    }
}
