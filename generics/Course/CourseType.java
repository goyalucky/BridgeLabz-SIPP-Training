public abstract class CourseType {
    protected String courseName;
    protected int credits;

    public CourseType(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public abstract void showEvaluationMethod();

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
}
