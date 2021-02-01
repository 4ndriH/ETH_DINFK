public class SelectionSort {
    int[] SelectionSort(int[] a) {
        int max, idx;
        for (int i = 1; i < a.length; i++) {
            max = idx = 0;
            for (int j = 0; j <= a.length - i; j++) {
                if (a[j] > max) {
                    max = a[j];
                    idx = j;
                }
            }
            a[idx] = a[a.length - i];
            a[a.length- i] = max;
        }
        return a;
    }
}