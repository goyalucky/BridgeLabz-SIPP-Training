package Assignments.MethodPractices.Level3;

import java.util.Arrays;

public class numberchecker {
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] storeDigits(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }


    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int num) {
        int[] digits = storeDigits(num);
        int[] reversed = reverseDigits(digits);
        return areArraysEqual(digits, reversed);
    }

    
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    
    public static boolean isNeonNumber(int num) {
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }


    public static boolean isSpyNumber(int[] digits) {
        int sum = 0, product = 1;
        for (int d : digits) {
            sum += d;
            product *= d;
        }
        return sum == product;
    }


    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return String.valueOf(square).endsWith(String.valueOf(num));
    }

    
    public static boolean isBuzzNumber(int num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }


    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    
    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum > num;
    }


    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum < num;
    }

    
    public static boolean isStrong(int num) {
        int[] digits = storeDigits(num);
        int sum = 0;
        for (int d : digits) {
            sum += factorial(d);
        }
        return sum == num;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


    public static void main(String[] args) {
        int num = 145;
        int[] digits = storeDigits(num);

        System.out.println("Number: " + num);
        System.out.println("Digit Count: " + countDigits(num));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed Digits: " + Arrays.toString(reverseDigits(digits)));
        System.out.println("Is Palindrome? " + isPalindrome(num));
        System.out.println("Is Duck Number? " + isDuckNumber(digits));
        System.out.println("Is Prime? " + isPrime(num));
        System.out.println("Is Neon Number? " + isNeonNumber(num));
        System.out.println("Is Spy Number? " + isSpyNumber(digits));
        System.out.println("Is Automorphic? " + isAutomorphic(num));
        System.out.println("Is Buzz Number? " + isBuzzNumber(num));
        System.out.println("Is Perfect? " + isPerfect(num));
        System.out.println("Is Abundant? " + isAbundant(num));
        System.out.println("Is Deficient? " + isDeficient(num));
        System.out.println("Is Strong Number? " + isStrong(num));
    }
}
