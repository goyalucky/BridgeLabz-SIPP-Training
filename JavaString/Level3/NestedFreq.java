package JavaString.Level3;

public class NestedFreq {
    public static void main(String[] args) {
        String text = "hello";
        boolean[] counted = new boolean[text.length()];
        for (int i = 0; i < text.length(); i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < text.length(); j++) {
                    if (text.charAt(i) == text.charAt(j)) {
                        count++;
                        counted[j] = true;
                    }
                }
                System.out.println(text.charAt(i) + " : " + count);
            }
        }
    }
}
