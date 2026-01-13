class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for(int[] mine : mines) {
            int row = mine[0], col = mine[1];
            dp[row][col] = -1;
        }
        for(int row = 0; row < n; row++) {
            int count = 0;
            for(int col = 0; col < n; col++) {
                if(dp[row][col] == -1) {
                    count = 0;
                } else {
                    count += 1;
                    dp[row][col] =  count;
                }
            }
            count = 0;
            for(int col = n - 1; col >= 0; col--) {
                if(dp[row][col] == -1) {
                    count = 0;
                } else {
                    count += 1;
                    dp[row][col] = Math.min(dp[row][col], count);
                }
            }
        }
        int max = 0;
        for(int col = 0; col < n; col++) {
            int count = 0;
            for(int row = 0; row < n; row++) {
                if(dp[row][col] == -1) {
                    count = 0;
                } else {
                    count += 1;
                    dp[row][col] = Math.min(dp[row][col], count);
                }
            }
            count = 0;
            for(int row = n - 1; row >= 0; row--) {
                if(dp[row][col] == -1) {
                    count = 0;
                } else {
                    count += 1;
                    dp[row][col] = Math.min(dp[row][col], count);
                }
                max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }
}