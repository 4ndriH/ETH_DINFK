public class Knapsack {
    public static void main(String args[]) {
        int[] values = new int[] {8, 8, 6, 5, 10, 5, 10, 17, 8, 20, 20};
		int[] weights = new int[] {5, 5, 6, 8, 10, 11, 12, 15, 5, 15, 30};

        System.out.println(dp(30, values, weights));
    }

    static int dp(int W, int[] values, int[] weights) {
        int[][] dp = new int[values.length + 1][W + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - weights[i - 1] >= 0)
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[weights.length][W];
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
