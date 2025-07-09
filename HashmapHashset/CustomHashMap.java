public class CustomHashMap {
    private static class Node {
        String key;
        int value;
        Node next;
        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;
    private Node[] map;

    public CustomHashMap() {
        map = new Node[SIZE];
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(String key, int value) {
        int index = getIndex(key);
        Node head = map[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = map[index];
        map[index] = newNode;
    }

    public int get(String key) {
        int index = getIndex(key);
        Node head = map[index];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return -1;
    }

    public void remove(String key) {
        int index = getIndex(key);
        Node head = map[index];
        Node prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) prev.next = head.next;
                else map[index] = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("apple", 100);
        map.put("banana", 80);
        System.out.println(map.get("apple"));
        map.remove("apple");
        System.out.println(map.get("apple"));
    }
}
