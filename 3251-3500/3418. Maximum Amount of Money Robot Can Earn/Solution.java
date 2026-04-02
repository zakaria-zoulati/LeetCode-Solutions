class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length ; 
        int m = coins[0].length ; 

        int[][][] dp = new int[n][m][3] ; 
        dp[0][0][0] = coins[0][0] ; 
        dp[0][0][1] = coins[0][0] > 0 ? coins[0][0] : 0 ; 
        dp[0][0][2] = dp[0][0][1] ; 
        for( int i=1 ; i<m ; ++i ){
            dp[0][i][0] = dp[0][i-1][0] + coins[0][i] ;
            dp[0][i][1] = Math.max( dp[0][i-1][1] + coins[0][i] , dp[0][i-1][0] ) ; 
            dp[0][i][2] = Math.max( dp[0][i-1][1] , dp[0][i-1][2] + coins[0][i] ) ; 
        }
        for( int i=1 ; i<n ; ++i ){
            dp[i][0][0] = dp[i-1][0][0] + coins[i][0] ;
            dp[i][0][1] = Math.max( dp[i-1][0][1] + coins[i][0] , dp[i-1][0][0] ) ; 
            dp[i][0][2] = Math.max( dp[i-1][0][1] , dp[i-1][0][2] + coins[i][0] ) ; 
        }

        for( int i=1 ; i<n ; ++i ){
            for( int j=1 ; j<m ; ++j ){
                dp[i][j][0] = coins[i][j] + Math.max( dp[i-1][j][0] , dp[i][j-1][0] ) ; 
                dp[i][j][1] = Math.max( dp[i-1][j][1] , dp[i][j-1][1] ) + coins[i][j] ; 
                dp[i][j][1] = Math.max( dp[i][j][1] , Math.max( dp[i-1][j][0] , dp[i][j-1][0] ) ) ;
                dp[i][j][2] = Math.max( dp[i-1][j][2] , dp[i][j-1][2] ) + coins[i][j] ; 
                dp[i][j][2] = Math.max( dp[i][j][2] , Math.max( dp[i-1][j][1] , dp[i][j-1][1] ) ) ;
            }
        }
        
        int ans = Math.max( dp[n-1][m-1][0] , Math.max( dp[n-1][m-1][1] , dp[n-1][m-1][2] ) ) ; 
        return ans ; 
    }
}