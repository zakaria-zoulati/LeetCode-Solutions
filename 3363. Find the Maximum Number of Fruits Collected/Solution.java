class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            rs += fruits[i][i] ; 
        }
        int[][] dp = new int[n][n] ; 
        dp[0][n-1] = fruits[0][n-1] ;
        dp[n-1][0] = fruits[n-1][0] ; 
        for( int i=1 ; i<n ; ++i ){
            int li = Math.max(n-1-i , i+1 ) ; 
            for( int j=n-1 ; j>=li  ; --j ){
                int b = Math.max( dp[i-1][j] , dp[i-1][j-1] ) ; 
                if( j<n-1 ) b = Math.max( b , dp[i-1][j+1] ) ; 
                dp[i][j] = b + fruits[i][j] ; 
            }
            for( int j=n-1 ; j>=li ; --j ){
                int b = Math.max( dp[j][i-1] , dp[j-1][i-1] ) ; 
                if( j < n-1 ) b = Math.max( b , dp[j+1][i-1] ) ; 
                dp[j][i] = b + fruits[j][i] ; 
            }
        }   
        rs += dp[n-1][n-2] + dp[n-2][n-1] ; 
        return rs ; 
    }
}