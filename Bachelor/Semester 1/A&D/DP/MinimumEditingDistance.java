public class MinimumEditingDistance {
    public static void main(String args[]) {
        String str1 = "TIGER";
        String str2 = "ZIEGE";

        System.out.println(dp(str1, str2));
    }

    static int dp(String str1, String str2) {
       int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					dp[i][j] = min(dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1), min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
				}
			}
		}

		return dp[str1.length()][str2.length()];
    }

    static int min(int a, int b) {
        return b < a ? b : a;
    }
}
