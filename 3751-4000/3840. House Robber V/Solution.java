class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length ; 
        long[] dp = new long[n] ; 
        dp[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
             if( colors[i-1] != colors[i] ){
                 dp[i] = dp[i-1] + nums[i] ; 
             } else {
                 dp[i] = Math.max( dp[i-1] , nums[i] + ( i-2 >= 0 ? dp[i-2] : 0 ) ) ; 
             }
        }
        return dp[n-1] ; 
    }
}