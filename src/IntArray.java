public class IntArray {
    private int[] array;
    private int size;

    public IntArray() {
        array = new int[4];
        size = 0;
    }

    public IntArray(int[] items) {
        this();
        for (int item : items) add(item);
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new RuntimeException();
        return array[index];
    }

    public int set(int index, int item) {
        int old = array[index];
        array[index] = item;
        return old;
    }

    public void add(int item) {
        if (size == array.length) resize(array.length * 2);
        array[size++] = item;
    }

    public void addAt(int index, int item) {
        if (size == array.length) resize(array.length * 2);

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = item;
        size++;
    }

    public int remove(int index) {
        int val = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return val;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public boolean removeItem(int item) {
        int index = indexOf(item);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCap) {
        int[] temp = new int[newCap];
        for (int i = 0; i < size; i++) temp[i] = array[i];
        array = temp;
    }

    @Override
    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            result += array[i];

            if (i < size - 1) {
                result += ", ";
            }
        }

        result += "]";
        return result;
    }

    public static void main(String[] args) {
        IntArray a = new IntArray();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a.removeLast());
    }
}