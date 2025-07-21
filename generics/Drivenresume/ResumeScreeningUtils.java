import java.util.List;

public class ResumeScreeningUtils {
    public static void screenAll(List<? extends JobRole> resumes) {
        System.out.println("\n=== Resume Screening Started ===");
        for (JobRole role : resumes) {
            role.evaluate();
        }
    }

    public static <T extends JobRole> void screenSingle(Resume<T> resume) {
        System.out.println("\n✅ Screening Single Resume:");
        resume.process();
    }
}
