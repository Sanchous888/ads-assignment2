public class QueueList implements IntQueue {
    private IntList list = new IntList();

    public boolean empty() { return list.isEmpty(); }

    public void add(int item) { list.addLast(item); }

    public int peek() { return list.getFirst(); }

    public int remove() { return list.removeFirst(); }

    public static void main(String[] args) {
        QueueList q = new QueueList();
        q.add(1);
        q.add(2);
        System.out.println(q.remove());
    }
}