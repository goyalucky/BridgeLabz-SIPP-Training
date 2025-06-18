package JavaString.Level2;

import java.util.*;

public class Scissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = {"rock", "paper", "scissors"};
        int playerWin = 0, compWin = 0, rounds = 5;
        Random rand = new Random();
        for (int i = 1; i <= rounds; i++) {
            String user = sc.next().toLowerCase();
            String comp = moves[rand.nextInt(3)];
            if (user.equals(comp)) {}
            else if (user.equals("rock") && comp.equals("scissors") || 
                     user.equals("paper") && comp.equals("rock") || 
                     user.equals("scissors") && comp.equals("paper")) playerWin++;
            else compWin++;
        }
        System.out.println("Player Wins | Computer Wins | Player % | Computer %");
        double pPerc = playerWin * 100.0 / rounds, cPerc = compWin * 100.0 / rounds;
        System.out.println("     " + playerWin + "        |      " + compWin + "        |   " + pPerc + "   |   " + cPerc);
    }
}
