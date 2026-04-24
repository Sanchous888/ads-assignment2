public class QueueStack implements IntQueue {
    private StackArray s1 = new StackArray();
    private StackArray s2 = new StackArray();

    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    public void add(int item) {
        s1.push(item);
    }

    public int peek() {
        if (s2.empty()) move();
        return s2.peek();
    }

    public int remove() {
        if (s2.empty()) move();
        return s2.pop();
    }

    private void move() {
        while (!s1.empty()) s2.push(s1.pop());
    }

    public static void main(String[] args) {
        QueueStack q = new QueueStack();
        q.add(1);
        q.add(2);
        System.out.println(q.remove());
    }
}