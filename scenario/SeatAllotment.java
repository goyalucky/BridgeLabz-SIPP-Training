import java.util.*;

public class SeatAllotment {

    static int binarySearch(int[] hall, int seat) {
        int low = 0, high = hall.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (hall[mid] == seat) return mid;
            else if (hall[mid] < seat) low = mid + 1;
            else high = mid - 1;
        }
        return -low - 1;
    }

    static void checkSeat(int[][] halls, int seatNumber) {
        for (int i = 0; i < halls.length; i++) {
            int pos = binarySearch(halls[i], seatNumber);
            if (pos >= 0) {
                System.out.println("Seat " + seatNumber + " found in Hall " + (i + 1) + " at position " + (pos + 1));
                return;
            }
        }

        System.out.println("Seat " + seatNumber + " not found.");
        suggestNearest(halls, seatNumber);
    }

    static void suggestNearest(int[][] halls, int seatNumber) {
        int nearest = Integer.MAX_VALUE;
        int bestHall = -1;

        for (int i = 0; i < halls.length; i++) {
            int[] hall = halls[i];
            int pos = Arrays.binarySearch(hall, seatNumber);
            if (pos < 0) {
                int insertPos = -pos - 1;
                if (insertPos < hall.length) {
                    int diff = Math.abs(seatNumber - hall[insertPos]);
                    if (diff < Math.abs(seatNumber - nearest)) {
                        nearest = hall[insertPos];
                        bestHall = i;
                    }
                }
                if (insertPos > 0) {
                    int diff = Math.abs(seatNumber - hall[insertPos - 1]);
                    if (diff < Math.abs(seatNumber - nearest)) {
                        nearest = hall[insertPos - 1];
                        bestHall = i;
                    }
                }
            }
        }

        if (nearest != Integer.MAX_VALUE) {
            System.out.println("Nearest available seat is " + nearest + " in Hall " + (bestHall + 1));
        } else {
            System.out.println("No nearby seat suggestions available.");
        }
    }

    public static void main(String[] args) {
        int[][] halls = {
            {101, 102, 105, 108},
            {201, 203, 205, 209},
            {301, 302, 304, 308}
        };

        checkSeat(halls, 205);
        checkSeat(halls, 106);
        checkSeat(halls, 400);
    }
}
