public class CircularTour {
     public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0, currSurplus = 0, start = 0;

        for (int i = 0; i < n; i++) {
            int surplus = petrol[i] - distance[i];
            totalSurplus += surplus;
            currSurplus += surplus;

            if (currSurplus < 0) {
                start = i + 1;
                currSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int startPoint = findStartingPoint(petrol, distance);

        if (startPoint != -1)
            System.out.println("Start at petrol pump: " + startPoint);
        else
            System.out.println("No possible tour.");
    }
}
