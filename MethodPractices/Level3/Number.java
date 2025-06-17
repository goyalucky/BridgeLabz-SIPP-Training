package Assignments.MethodPractices.Level3;

public class Number {
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
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }
    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int num, int[] digits) {
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }

    
    public static int[][] frequencyOfDigits(int[] digits) {
        int[][] freq = new int[10][2];  
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;  
            freq[i][1] = 0;  
        }

        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        int num = 1729;

        System.out.println("Number: " + num);
        System.out.println("Digit Count: " + countDigits(num));

        int[] digits = storeDigits(num);
        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("\nSum of Digits: " + sumOfDigits(digits));
        System.out.println("Sum of Squares of Digits: " + sumOfSquaresOfDigits(digits));
        System.out.println("Is Harshad Number? " + (isHarshadNumber(num, digits) ? "Yes" : "No"));

        System.out.println("\nDigit Frequencies:");
        int[][] frequencies = frequencyOfDigits(digits);
        for (int i = 0; i < 10; i++) {
            if (frequencies[i][1] > 0) {
                System.out.println("Digit " + frequencies[i][0] + " occurs " + frequencies[i][1] + " times");
            }
        }
    }
}
