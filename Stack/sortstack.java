import java.util.Stack;

public class sortstack {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, temp);
        }
    }

    public static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
