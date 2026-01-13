class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if( k == 0 ){
            return 1.0 ; 
        }
        if( n >= k+maxPts ){
            return 1.0 ; 
        }
        double[] dp = new double[n+1] ;
        dp[0] = 1 ;  
        double curr = 1 ; 
        double rs = 0 ; 
        for( int i=1 ; i<=n ; ++i ){
            dp[i] = curr/maxPts ; 
            if( i < k ){
                curr += dp[i] ; 
            }else {
                rs += dp[i] ; 
            }
            if( i >= maxPts ){
                curr -= dp[i-maxPts] ; 
            }
        }
        return rs ; 
    }
}