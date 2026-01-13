class Solution {
    int mod = 1_000_000_007 ; 
    public int numTilings(int n) {
        if( n <= 2 ) return n ; 
        int[] dp = new int[n+1] ; 
        dp[0] = 1 ; 
        dp[1] = 1 ; 
        dp[2] = 2 ;
        dp[3] = 5 ; 
        int accu = dp[0] + dp[1] ; 
        for( int i = 4 ; i<=n ; ++i ){
            dp[i] = ( (dp[i-1] + dp[i-2])%mod + (accu*2)%mod ) % mod ;
            accu = ( accu + dp[i-2] ) % mod ;
        }
        return dp[n] ; 
    }
}