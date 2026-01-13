class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        if( n == 1 || forget == 1 || forget <= delay ){
            return 1 ; 
        }
        int mod = 1_000_000_007 ; 
        int[] dp = new int[n+1] ; 
        dp[1] = 1 ; 
        int curr = 0 ; 
        for( int i=2 ; i<=n ; ++i ){
            if( i - forget >= 1 ){
                curr = ( curr - dp[i-forget] + mod ) % mod ; 
            }
            if( i - delay >= 1 ){
                curr = ( curr + dp[i-delay] ) % mod ;  
                dp[i] = curr ; 
            }
        }
        int rs = 0 ; 
        for( int i=n-forget+1; i<=n ; ++i ){
            rs = ( rs + dp[i] ) % mod ; 
        }
        return rs ; 
    }
}