public class MinHeap implements IntQueue {
    private IntArray heap = new IntArray();

    public boolean empty() { return heap.isEmpty(); }

    public void add(int item) {
        heap.add(item);
        up(heap.size() - 1);
    }

    public int peek() { return heap.get(0); }

    public int remove() {
        int root = heap.get(0);

        if (heap.size() == 1) {
            heap.removeLast();
            return root;
        }

        heap.set(0, heap.removeLast());
        down(0);
        return root;
    }

    private void up(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(i) < heap.get(p)) {
                swap(i, p);
                i = p;
            } else break;
        }
    }

    private void down(int i) {
        while (true) {
            int l = 2*i+1, r = 2*i+2, s = i;

            if (l < heap.size() && heap.get(l) < heap.get(s)) s = l;
            if (r < heap.size() && heap.get(r) < heap.get(s)) s = r;

            if (s != i) {
                swap(i, s);
                i = s;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.add(5);
        h.add(1);
        h.add(3);
        System.out.println(h.remove());
    }
}