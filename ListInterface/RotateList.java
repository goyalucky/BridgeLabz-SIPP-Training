import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        Scanner sc = new Scanner(System.in);
        int rotateBy = sc.nextInt();

        int n = list.size();
        rotateBy = rotateBy % n;
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(rotateBy, n));
        rotated.addAll(list.subList(0, rotateBy));

        System.out.println(rotated);
    }
}
