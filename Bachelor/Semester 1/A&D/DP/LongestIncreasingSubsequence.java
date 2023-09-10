public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int[] a = new int[]{8, 31, 83, 39, 54, 84, 88, 73, 63, 14};

        System.out.println(dp(a));
    }
    
    static int dp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        int length = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
	    int j = binarySearch(dp, a[i], 0, length);	
            dp[j] = a[i];
            if (j == length) {
                length++;
            }
	}
        
        return length;
    }

     static int binarySearch(int[] dp, int x, int l, int r) {
        while (r > l) {
            int m = (r + l) / 2;
            if (dp[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
