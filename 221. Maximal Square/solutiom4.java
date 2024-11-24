class Solution {
    public int maximalSquare(char[][] arr ) {
        int n = arr.length  ; 
        int m = arr[0].length ;
        int rs = 0 ; 
        int[][] dp = new int[n][m] ; 
        for( int i=0 ; i<m ; ++i ){
            dp[0][i] = arr[0][i] - '0' ; 
            rs |= dp[0][i] ; 
        }
        for( int i=0 ; i<n ; ++i ){
            dp[i][0] = arr[i][0] - '0' ;
            rs |= dp[i][0] ; 
        }
        for( int i=1 ; i<n ; ++i ){
            for( int j=1 ; j<m ; ++j ){
                if( arr[i][j] == '1' ){
                    dp[i][j] = Math.min( Math.min( dp[i][j-1] , dp[i-1][j] ) , dp[i-1][j-1] ) + 1 ; 
                    if( dp[i][j] > rs ) rs = dp[i][j] ; 
                }
            }
        }
        return rs*rs ; 
    }
}