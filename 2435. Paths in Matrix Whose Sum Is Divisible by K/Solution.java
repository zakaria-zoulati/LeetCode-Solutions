class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int mod = 1_000_000_007 ; 
        int[][][] dp = new int[n][m][k] ;
        
        dp[0][0][ grid[0][0] % k ] = 1 ;

        int p = grid[0][0] % k ; 
        for( int i=1 ; i<n ; ++i ){
            p = ( p + grid[i][0] ) % k ; 
            dp[i][0][p] = 1 ;
        }

        p = grid[0][0] % k ; 
        for( int j=1 ; j<m ; ++j ){
            p = ( p + grid[0][j] ) % k ; 
            dp[0][j][p] = 1 ; 
        }

        for( int i=1 ; i<n ; ++i ){
            for( int j=1 ; j<m ; ++j ){
                for( int t=0 ; t<k ; ++t ){
                    dp[i][j][ ( grid[i][j] + t ) % k ] = ( dp[i][j-1][t] + dp[i-1][j][t] ) % mod ; 
                }
            }
        }

        return dp[n-1][m-1][0] ; 
    }
}