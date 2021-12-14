public class SubSetSum {
    public static void main(String args[]) {
        int[] a = new int[] {5, 3, 7, 3, 1};

        System.out.println(dp(a, 9));
    }

    static boolean dp(int[] nums, int num) {
        boolean[][] dp = new boolean[nums.length + 1][num + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= num; j++) {
                dp[i][j] = dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]);
            }
        }

        return dp[nums.length][num];
    }
}
