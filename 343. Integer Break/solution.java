class Solution {
    public int integerBreak(int n) {
        if( n==2 ) return 1  ;
        if( n==3 ) return 2 ; 
        int[] dp = new int[n+1] ; 
        dp[2] = 2 ; 
        dp[1] = 1  ;
        dp[3] = 3 ; 
        for(int i=3 ; i<=n ; ++i){
            for(int j=2 ; j<=i/2  ; ++j){
                dp[i] = Math.max( dp[i-j]*dp[j],dp[i] ) ; 
            }
        }
        return dp[n] ; 
    }
}