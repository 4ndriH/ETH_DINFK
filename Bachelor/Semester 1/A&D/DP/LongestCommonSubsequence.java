public class LongestCommonSubsequence {
    public static void main(String args[]) {
        String str1 = "TIGER";
        String str2 = "ZIEGE";

        System.out.println(dp(str1, str2));
    }

    static int dp(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int d = str1.charAt(i - 1) == str2.charAt(j - 1) ? 1 : 0;
                dp[i][j] = max(dp[i][j - 1], max(dp[i - 1][j], dp[i - 1][j - 1] + d));
            }
        }

        return dp[str1.length()][str2.length()];
    }

    static int max(int a, int b) {
        return b > a ? b : a;
    }
}