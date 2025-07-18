import java.time.LocalDate;
import java.util.*;

public class MoodTracker {
    HashMap<LocalDate, List<String>> moodLog = new HashMap<>();

    void logMood(LocalDate date, String mood) {
        moodLog.putIfAbsent(date, new ArrayList<>());
        moodLog.get(date).add(mood.toLowerCase());
        System.out.println("Logged: " + mood + " on " + date);
    }

    void searchMood(String mood) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(30);

        int count = 0;
        List<LocalDate> dates = new ArrayList<>();

        for (Map.Entry<LocalDate, List<String>> entry : moodLog.entrySet()) {
            LocalDate date = entry.getKey();
            if (!date.isBefore(startDate) && !date.isAfter(today)) {
                for (String m : entry.getValue()) {
                    if (m.equalsIgnoreCase(mood)) {
                        count++;
                        dates.add(date);
                    }
                }
            }
        }

        System.out.println("Mood '" + mood + "' occurred " + count + " time(s) in the last 30 days.");
        if (!dates.isEmpty()) {
            System.out.println("Dates:");
            for (LocalDate d : dates) {
                System.out.println(" - " + d);
            }
        }
    }

    public static void main(String[] args) {
        MoodTracker tracker = new MoodTracker();

        tracker.logMood(LocalDate.now().minusDays(1), "Happy");
        tracker.logMood(LocalDate.now().minusDays(2), "Tired");
        tracker.logMood(LocalDate.now().minusDays(2), "Sad");
        tracker.logMood(LocalDate.now().minusDays(5), "Happy");
        tracker.logMood(LocalDate.now().minusDays(10), "Happy");
        tracker.logMood(LocalDate.now().minusDays(15), "Sad");
        tracker.logMood(LocalDate.now().minusDays(20), "Tired");
        tracker.logMood(LocalDate.now().minusDays(35), "Happy"); // outside range

        tracker.searchMood("Happy");
        tracker.searchMood("Sad");
    }
}
