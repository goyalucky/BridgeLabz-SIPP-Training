import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer("Alice", 4);
        DataScientist ds = new DataScientist("Bob", 3);
        ProductManager pm = new ProductManager("Charlie", 5);

        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        Resume<DataScientist> dsResume = new Resume<>(ds);
        Resume<ProductManager> pmResume = new Resume<>(pm);

        ResumeScreeningUtils.screenSingle(seResume);
        ResumeScreeningUtils.screenSingle(dsResume);
        ResumeScreeningUtils.screenSingle(pmResume);

        List<JobRole> resumeList = new ArrayList<>();
        resumeList.add(se);
        resumeList.add(ds);
        resumeList.add(pm);
        
        ResumeScreeningUtils.screenAll(resumeList);
    }
}
