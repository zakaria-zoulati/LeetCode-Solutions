class Solution {
    public int countSquares(int[][] arr) {
        int n = arr.length ; 
        int m = arr[0].length ; 
        int rs = 0 ; 
        int[][] dp = new int[n+1][m+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            for( int j=1 ; j<=m ; ++j ){
                if( arr[i-1][j-1] == 1 ){
                    dp[i][j] = 1 + Math.min( dp[i-1][j-1] , Math.min( dp[i][j-1] , dp[i-1][j]  ) ) ; 
                    rs += dp[i][j] ; 

                }
            }
        }
        return rs ; 
    }
}