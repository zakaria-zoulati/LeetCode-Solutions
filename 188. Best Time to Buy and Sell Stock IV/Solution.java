class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (k >= n / 2) { 
            int profit = 0;
            for (int i = 1; i < n; ++i)
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            return profit;
        }
        int[][] dp = new int[n][k + 1];
        int[] prev = new int[k + 1]; 
        for (int t = 0; t <= k; ++t) prev[t] = -prices[0];
        int rs = 0 ; 
        for (int i = 1; i < n; ++i) {
            int l = Math.min( i+1 , k ) ; 
            for (int t = 1; t<=l ; ++t) {
                dp[i][t] = dp[i - 1][t];
                dp[i][t] = Math.max(dp[i][t], prices[i] + prev[t]);
                prev[t] = Math.max(prev[t], dp[i - 1][t - 1] - prices[i]);
                rs = Math.max( rs , dp[i][t] ) ; 
            }
        }
        return rs ; 
    }
}
