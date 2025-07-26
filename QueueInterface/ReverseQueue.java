package QueueInterface;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);
        System.out.println(queue);
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int temp = queue.remove();
        reverse(queue);
        queue.add(temp);
    }
}
