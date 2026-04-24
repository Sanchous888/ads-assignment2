public class StackQueue implements IntStack {
    private QueueList q1 = new QueueList();
    private QueueList q2 = new QueueList();

    public boolean empty() { return q1.empty(); }

    public void push(int item) {
        q2.add(item);
        while (!q1.empty()) q2.add(q1.remove());
        QueueList temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() { return q1.remove(); }

    public int peek() { return q1.peek(); }

    public static void main(String[] args) {
        StackQueue s = new StackQueue();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
    }
}