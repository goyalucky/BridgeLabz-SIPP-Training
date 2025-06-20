package Assignments.BuildinFunction.Level1;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int low = 1, high = 100;
        boolean guessed = false;
        while (!guessed) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = getFeedback();
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("I guessed it!");
                guessed = true;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
            if (low > high) {
                System.out.println("Inconsistent feedback. Exiting.");
                break;
            }
        }
    }

    static int generateGuess(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }

    static String getFeedback() {
        return sc.next();
    }
}
