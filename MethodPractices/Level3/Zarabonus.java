import java.util.Random;

public class Zarabonus {
    public static int[][] generateEmployeeData(int count) {
        Random rand = new Random();
        int[][] data = new int[count][2]; 

        for (int i = 0; i < count; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); 
            data[i][1] = 1 + rand.nextInt(10); 
        }
        return data;
    }

 
    public static double[][] calculateBonusAndNewSalary(int[][] data) {
        double[][] result = new double[data.length][2]; 

        for (int i = 0; i < data.length; i++) {
            double bonus = (data[i][1] > 5)
                    ? data[i][0] * 0.05
                    : data[i][0] * 0.02;
            double newSalary = data[i][0] + bonus;

            result[i][0] = bonus;
            result[i][1] = newSalary;
        }
        return result;
    }

   
    public static void displayResults(int[][] data, double[][] results) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");
        for (int i = 0; i < data.length; i++) {
            totalOldSalary += data[i][0];
            totalNewSalary += results[i][1];
            totalBonus += results[i][0];
            System.out.printf("%d\t%d\t\t%d\t%.2f\t%.2f\n",
                    (i + 1), data[i][0], data[i][1], results[i][0], results[i][1]);
        }

        System.out.printf("Total\t%.2f\t\t%.2f\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);
    }
    public static void main(String[] args) {
        int employeeCount = 10;
        int[][] employeeData = generateEmployeeData(employeeCount);
        double[][] salaryResults = calculateBonusAndNewSalary(employeeData);
        displayResults(employeeData, salaryResults);
    }
}
