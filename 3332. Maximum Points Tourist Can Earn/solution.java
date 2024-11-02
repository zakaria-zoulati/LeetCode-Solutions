class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] dp = new int[k][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = stayScore[0][i];
            for( int j=0 ; j<n ; ++j ){
                dp[0][i] = Math.max( dp[0][i] , travelScore[j][i] ) ; 
            } 
        }
        for (int d = 1; d < k;++d) {
            for (int c = 0; c < n; ++c) {
                dp[d][c] = dp[d - 1][c] + stayScore[d][c];
                for (int p = 0; p < n; ++p) {
                    dp[d][c] = Math.max(dp[d][c], dp[d - 1][p] + travelScore[p][c]) ; 
                }
            }
        }
        int score = 0 ; 
        for( int p : dp[k-1] ){
            if( p > score ) score = p ; 
        }
        return score ; 
    }
}
