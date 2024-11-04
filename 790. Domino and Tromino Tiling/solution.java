class Solution {
    int mod = 1_000_000_007 ; 
    public int numTilings(int n) {
        if( n <= 2 ) return n ; 
        int[] dp = new int[n+1] ; 
        dp[0] = 1 ; 
        dp[1] = 1 ; 
        dp[2] = 2 ;
        dp[3] = 5 ; 
        for( int i = 3 ; i<=n ; ++i ){
           dp[i] = ( dp[i-1] + dp[i-2] ) % mod ;
           for( int j=i-1 ; j>=2 ; --j ){
                dp[i] = ( dp[i] + (2*dp[j-2])%mod ) % mod ;  
           }
        }
        return dp[n] ; 
    }
}