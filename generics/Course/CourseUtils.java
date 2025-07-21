import java.util.List;

public class CourseUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        System.out.println("=== Course Catalog ===");
        for (CourseType course : courses) {
            course.showEvaluationMethod();
        }
    }
}
