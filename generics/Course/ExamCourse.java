public class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println("Exam-Based Course: " + courseName + " | Credits: " + credits + " | Evaluation: Final Exam");
    }
}
