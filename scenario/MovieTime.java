import java.time.LocalTime;
import java.util.*;

class Show {
    String title;
    LocalTime time;

    Show(String title, String time) {
        this.title = title;
        this.time = LocalTime.parse(time);
    }

    public String toString() {
        return title + " at " + time;
    }
}

class Theater {
    List<Show> showList = new ArrayList<>();

    public void addShow(String title, String time) {
        Show newShow = new Show(title, time);
        showList.add(newShow);
        insertionSortByTime();
    }

    private void insertionSortByTime() {
        for (int i = 1; i < showList.size(); i++) {
            Show key = showList.get(i);
            int j = i - 1;
            while (j >= 0 && showList.get(j).time.isAfter(key.time)) {
                showList.set(j + 1, showList.get(j));
                j--;
            }
            showList.set(j + 1, key);
        }
    }

    public void displayShows() {
        System.out.println("Upcoming Shows:");
        for (Show show : showList) {
            System.out.println(show);
        }
    }
}

public class MovieTime {
    public static void main(String[] args) {
        Theater theater = new Theater();

        theater.addShow("Avengers", "15:30");
        theater.addShow("The Dark Knight", "13:45");
        theater.addShow("Inception", "17:00");
        theater.addShow("Finding Nemo", "11:00");

        theater.displayShows();
    }
}
