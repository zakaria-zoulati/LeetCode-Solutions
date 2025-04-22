class Solution {
    int mod = (int)1e9 + 7;
    int[][] comb = new int[10001][15]; 

    public void precomputeComb(int n, int k) {
        for (int i = 0; i <= n; ++i) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, k); ++j) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        precomputeComb(n, 14); 
        int[][] dp = new int[maxValue + 1][15];
        for (int i = 1; i <= maxValue; ++i) {
            dp[i][1] = 1;
        }

        for (int len = 2; len <= 14; ++len) {
            for (int i = 1; i <= maxValue; ++i) {
                for (int mult = 2 * i; mult <= maxValue; mult += i) {
                    dp[mult][len] = (dp[mult][len] + dp[i][len - 1]) % mod;
                }
            }
        }

        long res = 0;
        for (int val = 1; val <= maxValue; ++val) {
            for (int len = 1; len <= 14; ++len) {
                if (dp[val][len] > 0 && n >= len) {
                    res = (res + (long)dp[val][len] * comb[n - 1][len - 1]) % mod;
                }
            }
        }

        return (int) res;
    }
}
