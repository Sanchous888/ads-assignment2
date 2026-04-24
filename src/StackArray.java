public class StackArray implements IntStack {
    private IntArray arr = new IntArray();

    public boolean empty() { return arr.isEmpty(); }

    public int peek() { return arr.get(arr.size() - 1); }

    public int pop() { return arr.removeLast(); }

    public void push(int item) { arr.add(item); }

    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
    }
}