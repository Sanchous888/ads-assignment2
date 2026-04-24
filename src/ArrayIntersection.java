public class ArrayIntersection {
    public static IntArray intersect(IntArray A, IntArray B) {
        IntArray res = new IntArray();

        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (B.indexOf(x) != -1 && res.indexOf(x) == -1) {
                res.add(x);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        IntArray A = new IntArray(new int[]{1,2,3,4});
        IntArray B = new IntArray(new int[]{3,4,5});
        System.out.println(intersect(A, B));
    }
}