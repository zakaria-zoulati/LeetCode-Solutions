class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length ; 
        int m = 0 ; 
        for( int i : nums ){
            m = Math.max( m , i ) ; 
        }
        int bits = 32 - Integer.numberOfLeadingZeros(m) ; 
        int all = ( 1 << bits ) - 1; 
        int[] dp = new int[all+1] ; 
        for( int i : nums ) dp[i]=i ; 
        for( int i=0 ; i<bits ; ++i ){
            for( int mask=1 ; mask<=all ; mask++ ){
                if( ( mask & ( 1 << i ) ) > 0 ){
                    dp[mask] = Math.max( dp[mask] , dp[mask^(1<<i)] ) ; 
                }
            } 
        }
        long rs = 0 ; 
        for( int i : nums ){
            rs = Math.max( rs , i * 1L * dp[i^all] ) ; 
        }
        return rs ; 
    }
}