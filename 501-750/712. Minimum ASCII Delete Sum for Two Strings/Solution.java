class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[] b1 = s1.chars().toArray() ; 
        int[] b2 = s2.chars().toArray() ; 
        int n = s1.length() ; 
        int m = s2.length() ; 
        int[][] dp = new int[n+1][m+1] ; 
        for( int i=0 ; i<m ; ++i ){
            dp[0][i+1] = dp[0][i] + b2[i] ; 
        }
        for( int i=0 ; i<n ; ++i ){
            dp[i+1][0] = dp[i][0] + b1[i] ; 
        }
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( b1[i] == b2[j] ){
                    dp[i+1][j+1] = dp[i][j] ; 
                }else {
                    dp[i+1][j+1] = Math.min( dp[i+1][j] + b2[j] , dp[i][j+1] + b1[i] ) ; 
                }
            }
        }
        return dp[n][m] ; 
    }
}