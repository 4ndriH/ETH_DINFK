public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int[] a = new int[]{8, 31, 83, 39, 54, 84, 88, 73, 63, 14};

        System.out.println(dp(a));
    }

    static int dp(int[] a) {
        int[] dp = new int[a.length];
        int length = 1;
    	
        for (int i = 1; i < a.length; i++) {
            if (a[i] < dp[0]) {
            	dp[0] = a[i];
            } else if (a[i] > dp[length - 1]) {
            	dp[length++] = a[i];
            } else {
            	dp[BinarySearch(dp, -1, length - 1, a[i])] = a[i];
            }
        }
        
        return length;
    }

     static int BinarySearch(int[] a, int left, int right, int search) {
         while (right - left > 1) {
             int mid = left + (right - left) / 2;
             if (a[mid] < search) {
            	 left = mid;
             } else {
            	 right = mid;
             }
         }
  
         return right;
     }
}
