package JavaString.Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardDeck {
    public static void main(String[] args) {
         String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<String> deck = new ArrayList<>();
        for (String s : suits) for (String r : ranks) deck.add(r + s);
        Collections.shuffle(deck);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), players = sc.nextInt();
        for (int p = 0; p < players; p++) {
            System.out.print("Player " + (p + 1) + ": ");
            for (int c = 0; c < n; c++) System.out.print(deck.remove(0) + " ");
            System.out.println();
        }
    }
}
