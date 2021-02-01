public class BinarySearch {
    int BinarySearch(int[] a, int search) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == search) {
                return mid;
            } else if (a[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
}
