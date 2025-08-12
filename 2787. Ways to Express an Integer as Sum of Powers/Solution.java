class Solution {
    public int numberOfWays(int n, int x) {
        if( n == 1 ){
            return 1 ; 
        }
        int mod = 1_000_000_007 ;
        long[] dp = new long[n+1] ; 
        dp[0] = 1 ; 
        for( int i=1 ; Math.pow(i,x) <= n ; ++i ){
            int num = (int) Math.pow(i,x) ; 
            for( int j=n ; j>=num ; --j ){
                dp[j] += dp[j-num] ; 
            }
        }
        dp[n] %= mod ;
        return (int) dp[n] ;  
    }
}