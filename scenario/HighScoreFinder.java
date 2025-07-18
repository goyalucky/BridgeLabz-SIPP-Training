import java.util.*;

public class HighScoreFinder {
    ArrayList<Integer> topScores = new ArrayList<>();

    void addScores(List<Integer> scores) {
        topScores.addAll(scores);
        topScores.sort(Collections.reverseOrder());
        if (topScores.size() > 100) {
            topScores = new ArrayList<>(topScores.subList(0, 100));
        }
    }

    int binarySearchDescending(ArrayList<Integer> list, int score) {
        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == score) return mid;
            else if (list.get(mid) < score) high = mid - 1;
            else low = mid + 1;
        }
        return -low - 1; 
    }

    void checkScore(int playerScore) {
        int index = binarySearchDescending(topScores, playerScore);
        if (index >= 0) {
            System.out.println("Congrats! Your score is in the top 100. Rank: " + (index + 1));
        } else {
            int insertPos = -index - 1;
            if (topScores.size() < 100) {
                System.out.println("Your score would be added at rank: " + (insertPos + 1));
            } else {
                int requiredScore = topScores.get(topScores.size() - 1) + 1;
                int needed = requiredScore - playerScore;
                System.out.println("Sorry, you need at least " + needed + " more points to enter top 100.");
            }
        }
    }

    public static void main(String[] args) {
        HighScoreFinder game = new HighScoreFinder();

        Random rand = new Random();
        List<Integer> dummyScores = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dummyScores.add(rand.nextInt(1000) + 1); 
        }

        game.addScores(dummyScores);
        game.checkScore(875); 
        game.checkScore(2500);
        game.checkScore(10);
    }
}
