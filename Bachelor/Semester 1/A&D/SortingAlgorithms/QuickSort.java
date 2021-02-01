public class QuickSort {
    int[] QuickSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = split(a, left, right);
            QuickSort(a, left, mid - 1);
            QuickSort(a, mid + 1, right);
        }
        return a;
    }

    int split(int[] a, int left, int right) {
        int l = left;
        int r = right - 1;
        int pivot = a[right];

        do {
            while (l < right && a[l] < pivot) {
                l++;
            }
            while (r > left && a[r] > pivot) {
                r--;
            }
            if (l < r) {
                QSswap(a, l, r);
            }
        } while (l < r);
        QSswap(a, l, right);
        return l;
    }

    int[] QSswap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        return a;
    }
}