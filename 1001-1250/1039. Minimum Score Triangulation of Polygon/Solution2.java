class Solution {
    public int minScoreTriangulation(int[] values) {
       int n = values.length ; 
       int[][] dp = new int[n][n] ; 
       for( int len=3 ; len<=n ; ++len ){
            for( int i=0 ; i+len-1<n ;++i ){
                int r = i + len -1 ; 
                dp[i][r] = Integer.MAX_VALUE ; 
                for( int k=i+1 ; k<r ; ++k ){
                    dp[i][r] = Math.min( dp[i][r] , 
                    dp[i][k] + dp[k][r] + values[i]*values[k]*values[r] 
                    );
                }
            }
       }
       return dp[0][n-1] ; 
    }
}
