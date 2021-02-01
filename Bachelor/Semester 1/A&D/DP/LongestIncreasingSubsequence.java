public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int[] a = new int[]{8, 31, 83, 39, 54, 84, 88, 73, 63, 14};

        System.out.println(dp(a));
    }

    static int dp(int[] a) {
        int[] dp = new int[a.length];
        int len = 0;
		
        for (int num : a) {
            int i = BinarySearch(dp,0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    static int BinarySearch(int[] a, int left, int right, int search) {
        int mid = a.length / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] == search) {
                return mid;
            } else if (a[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return - mid - 1;
    }
}