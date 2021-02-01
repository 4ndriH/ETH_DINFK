public class MergeSort {
    int[] MergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(a, left, mid);
            MergeSort(a, mid + 1, right);
            Merge(a, left, mid , right);
        }
        return a;
    }

    int[] Merge (int[] a, int left, int mid, int right) {
        int[] b = new int[right - left + 1];
        int l = left;
        int m = mid + 1;
        int k = 0;

        while (l <= mid && m <= right) {
            if (a[l] < a[m]) {
                b[k++] = a[l++];
            } else {
                b[k++] = a[m++];
            }
        }
        while (l <= mid) {
            b[k++] = a[l++];
        }
        while (m <= right) {
            b[k++] = a[m++];
        }
        for (int i = left; i <= right; i++) {
            a[i] = b[i - left];
        }
        return a;
    }
}