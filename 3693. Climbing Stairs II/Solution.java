class Solution {
    public int climbStairs(int n, int[] cost) {
       int[] dp = new int[n+1] ; 
        dp[0] = 0 ; 
        for( int i=1 ; i<=n ; ++i ){
            dp[i] = Integer.MAX_VALUE  ;
            dp[i] = Math.min( dp[i] , cost[i-1] + 1 + dp[i-1] ) ; 
            if( i >= 2 ){
                dp[i] = Math.min( dp[i] , cost[i-1] + 4 + dp[i-2] ) ; 
            }
            if( i >= 3 ){
                dp[i] = Math.min( dp[i] , cost[i-1] + 9 + dp[i-3] ) ; 
            }
        }
        return dp[n] ; 
    }
}