class Solution {
    public int maximalSquare(char[][] arr ) {
        int n = arr.length  ; 
        int m = arr[0].length ;
        int rs = 0 ; 
        int[][] dp = new int[n+1][m+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            for( int j=1 ; j<=m ; ++j ){
                if( arr[i-1][j-1] == '1' ){
                    dp[i][j] = Math.min( Math.min( dp[i-1][j] , dp[i][j-1] ) , dp[i-1][j-1]  ) + 1 ; 
                    rs = Math.max( rs , dp[i][j]*dp[i][j] ) ; 
                }
            }
        }
        return rs ; 
    }
}