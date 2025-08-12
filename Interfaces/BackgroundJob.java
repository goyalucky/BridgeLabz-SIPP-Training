public class BackgroundJob {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Job Running");
        job.run();
    }
}
