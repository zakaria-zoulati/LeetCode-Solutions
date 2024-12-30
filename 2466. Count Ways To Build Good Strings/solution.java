class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007 ; 
        int[] dp = new int[high+1] ;
        int rs = 0 ; 
        dp[0] = 0 ; 
        dp[zero]++ ;
        dp[one]++ ; 
        for( int i=1 ; i<=high ; ++i ){
            dp[i] = ( dp[i] + (i-one>=0?dp[i-one]:0) + (i-zero>=0?dp[i-zero]:0) ) % mod ;
            if( i>=low ){
                rs = ( rs + dp[i] ) % mod;
            }
        }
        return rs ;
    }
}