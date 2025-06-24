package JavaStringMoreproblems;

public class RemoveChar {
    public static void main(String[] args) {
        String str = "Hello World";
        char ch = 'l';
        String result = "";
        for (char c : str.toCharArray())
            if (c != ch) result += c;
        System.out.println(result);
    }
}
