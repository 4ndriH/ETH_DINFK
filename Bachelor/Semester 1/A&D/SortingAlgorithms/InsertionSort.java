public class InsertionSort {
    int[] InsertionSort(int[] a) {
        int idx, temp;
        for (int i = 1; i < a.length; i++) {
            idx = 0;
            temp = a[i];
            while (temp > a[idx]){
                idx++;
            }
            for (int j = i; j > idx; j--) {
                a[j] = a[j - 1];
            }
            a[idx] = temp;
        }
        return a;
    }
}