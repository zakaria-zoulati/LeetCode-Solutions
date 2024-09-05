class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = ( (int) 1e9 ) + 7 ; 
        if( target < n || target > n*k ){
            return 0 ; 
        }
        if( n==1 ) return 1 ; 
        int[][] dp = new int[n+1][n*k+1] ;
        for(int i=1 ; i<=k ; ++i){
            dp[1][i] = 1 ; 
        }
        for(int i=2 ; i<=n ; ++i){ 
            for(int t=i ; t<=i*k ; ++t ){  
                for(int j = 1; j<=k && t-j>=1  ; ++j){ 
                    dp[i][t] = ( dp[i][t]  + dp[1][j]*dp[i-1][t-j])%mod ;  
                }
            }
        }
        return dp[n][target] ; 
    }
}