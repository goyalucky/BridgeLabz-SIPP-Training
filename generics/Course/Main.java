import java.util.*;

public class Main {
    public static void main(String[] args) {
        ExamCourse maths = new ExamCourse("Engineering Mathematics", 4);
        AssignmentCourse javaLab = new AssignmentCourse("Java Programming Lab", 3);
        ResearchCourse aiResearch = new ResearchCourse("AI Thesis", 6);

        Course<ExamCourse> course1 = new Course<>(maths);
        Course<AssignmentCourse> course2 = new Course<>(javaLab);
        Course<ResearchCourse> course3 = new Course<>(aiResearch);

        List<CourseType> courseList = new ArrayList<>();
        courseList.add(course1.getCourseDetails());
        courseList.add(course2.getCourseDetails());
        courseList.add(course3.getCourseDetails());

        CourseUtils.displayAllCourses(courseList);
    }
}
