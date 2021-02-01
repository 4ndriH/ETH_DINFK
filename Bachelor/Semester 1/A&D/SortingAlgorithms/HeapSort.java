public class HeapSort {
    int[] HeapSort(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            restoreHeapCondition(a, i, a.length - 1);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            HSswap(a, i, 0);
            restoreHeapCondition(a, 0, i - 1);
        }
        return a;
    }

    int[] restoreHeapCondition(int[] a, int index, int right) {
        while (2 * index <= right) {
            int temp = index * 2;
            if (temp + 1 <= right && a[temp] <= a[temp + 1]) {
                temp++;
            }
            if (a[index] >= a[temp]) {
                break;
            }
            HSswap(a, index, temp);
            index = temp;
        }
        return a;
    }

    int[] HSswap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        return a;
    }
}