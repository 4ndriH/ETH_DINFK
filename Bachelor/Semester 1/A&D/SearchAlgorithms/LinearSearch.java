public class LinearSearch {
    int LinearSearch(int[] a, int search) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
}
