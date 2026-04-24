public class IntList {
    private Node head;
    private int size;

    public IntList() {
        head = null;
        size = 0;
    }

    public int size() { return size; }

    boolean isEmpty() { return size == 0; }

    public void addFirst(int item) {
        head = new Node(item, head);
        size++;
    }

    public void addLast(int item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = new Node(item);
        }
        size++;
    }

    public int getFirst() { return head.value; }

    public int removeFirst() {
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public void reverse() {
        Node prev = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
    }

    static class Node {
        int value;
        Node next;

        Node(int v) { value = v; }
        Node(int v, Node n) { value = v; next = n; }
    }

    public static void main(String[] args) {
        IntList list = new IntList();
        list.addLast(1);
        list.addLast(2);
        list.reverse();
        System.out.println(list.getFirst());
    }
}