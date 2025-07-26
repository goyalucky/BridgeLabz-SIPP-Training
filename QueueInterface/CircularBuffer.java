package QueueInterface;

public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(int val) {
        buffer[rear] = val;
        rear = (rear + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity;
        }
    }

    public void printBuffer() {
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(buffer[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(10);
        cb.enqueue(20);
        cb.enqueue(30);
        cb.printBuffer();
        cb.enqueue(40);
        cb.printBuffer(); 
    }
}
