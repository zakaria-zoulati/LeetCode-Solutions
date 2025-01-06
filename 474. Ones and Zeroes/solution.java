class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[n + 1][m + 1]; 
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            for (int i = n; i >= ones; --i) {
                for (int j = m; j >= zeros; --j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - ones][j - zeros] + 1);
                }
            }
        }
        return dp[n][m];
    }
}
