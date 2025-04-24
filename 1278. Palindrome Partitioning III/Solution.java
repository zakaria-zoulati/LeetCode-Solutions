class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    cost[i][j] = (len == 2) ? 0 : cost[i + 1][j - 1];
                } else {
                    cost[i][j] = 1 + ((len == 2) ? 0 : cost[i + 1][j - 1]);
                }
            }
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 99999);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(i, k); ++j) {
                for (int t = j - 1; t < i; ++t) {
                    dp[i][j] = Math.min(dp[i][j], dp[t][j - 1] + cost[t][i - 1]);
                }
            }
        }

        return dp[n][k];
    }
}
