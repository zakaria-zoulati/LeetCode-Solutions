class Solution {
    public long numberOfWays(String s) {
        int n = s.length() ; 
        int[] dp = new int[n] ; 
        if( s.charAt(0) == '0' ){
            dp[0] = 1 ; 
        }
        for( int i=1 ; i<n ; ++i ){
            dp[i] += dp[i-1] ; 
            dp[i] += 1 - ( s.charAt(i) - '0' ) ; 
        }
        long rs = 0L ; 
        for( int i=1 ; i<n-1 ;  ){
            if( s.charAt(i) == '0' ){
                rs += (long) ( i - dp[i-1] )*( n-i-1 - ( dp[n-1] -  dp[i++] ) ) ; 
            }else {
                rs += (long) dp[i-1]*( dp[n-1] - dp[i++] ) ; 
            }
        }
        return rs ; 
    }
}