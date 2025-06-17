package Assignments.MethodPractices.Level3;

public class checker {
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
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }
    public static boolean isArmstrong(int num) {
        int n = countDigits(num);
        int sum = 0, original = num;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, n);
            num /= 10;
        }
        return sum == original;
    }
    public static int[] largestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }
    public static int[] smallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        int num = 153;

        System.out.println("Number: " + num);
        System.out.println("Digit Count: " + countDigits(num));

        int[] digits = storeDigits(num);
        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("\nDuck Number? " + (isDuckNumber(digits) ? "Yes" : "No"));
        System.out.println("Armstrong Number? " + (isArmstrong(num) ? "Yes" : "No"));

        int[] largestTwo = largestAndSecondLargest(digits);
        System.out.println("Largest: " + largestTwo[0]);
        System.out.println("Second Largest: " + largestTwo[1]);

        int[] smallestTwo = smallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + smallestTwo[0]);
        System.out.println("Second Smallest: " + smallestTwo[1]);
    }
}
