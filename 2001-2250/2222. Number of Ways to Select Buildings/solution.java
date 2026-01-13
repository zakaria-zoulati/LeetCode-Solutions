class Solution {
    public long numberOfWays(String s) {
        int n = s.length() ; 
        int[][] dp = new int[n][2] ; 
        dp[0][ s.charAt(0) - '0'] = 1 ; 
        for( int i=1 ; i<n ; ++i ){
            dp[i][0] += dp[i-1][0] ; 
            dp[i][1] += dp[i-1][1] ; 
            dp[i][ s.charAt(i) - '0' ]++ ; 
        }
        long rs = 0L ; 
        for( int i=1 ; i<n-1 ; ++i ){
            int c = 1 - ( s.charAt(i) - '0' ) ;
            rs += (long) dp[i-1][c]*( dp[n-1][c] - dp[i][c] ) ;  
        }
        return rs ; 
    }
}