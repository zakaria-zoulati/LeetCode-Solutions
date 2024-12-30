class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007 ; 
        int[] dp = new int[high+1] ;
        int rs = 0 ; 
        dp[0] = 1 ; 
        if( one < zero ){
            int temp = Math.min( one , zero ) ; 
            one = Math.max( one , zero ) ;
            zero = temp ; 
        }
        for( int i=1 ; i<=high ; ++i ){
            if( i>=one ){
                dp[i] = ( dp[i-one] + dp[i-zero] ) % mod ; 
            }else if( i>= zero ){
                 dp[i] = dp[i-zero] ;
            }
            if( i>=low ){
                rs = ( rs + dp[i] )%mod;
            }
        }
        return rs ;
    }
}