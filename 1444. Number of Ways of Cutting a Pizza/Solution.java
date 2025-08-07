class Solution {
    public int ways(String[] pizza, int k) {
        int n = pizza.length; 
        int m = pizza[0].length(); 
        int mod = 1_000_000_007; 

        int[][] count = new int[n + 1][m + 1]; 
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                count[i][j] = count[i][j + 1] + count[i + 1][j] - count[i + 1][j + 1]; 
                if (pizza[i].charAt(j) == 'A') {
                    count[i][j]++; 
                }
            }
        }

        if (k == 1) {
            return count[0][0] > 0 ? 1 : 0; 
        }
        if (count[0][0] < k) return 0; 

        int[][][] dp = new int[n][m][k + 1]; 

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (count[i][j] > 0) {
                    dp[i][j][1] = 1; 
                }
                int c = count[i][j]; 
                int curr = c<k ? c : k ; 
                for (int t = 2; t <= curr; ++t) {
                    for (int a = i + 1; a < n; ++a) {
                        if (count[a][j] < c) {
                            dp[i][j][t] = (dp[i][j][t] + dp[a][j][t - 1]) % mod; 
                        }
                    }
                    for (int a = j + 1; a < m; ++a) {
                        if (count[i][a] < c) {
                            dp[i][j][t] = (dp[i][j][t] + dp[i][a][t - 1]) % mod; 
                        }
                    }
                }
            }
        }

        return dp[0][0][k]; 
    }
}
