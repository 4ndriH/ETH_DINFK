public class BubbleSort {
    int[] BubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
}
