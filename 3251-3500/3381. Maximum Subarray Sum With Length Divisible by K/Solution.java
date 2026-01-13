class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length ;   
        long curr = 0 ; 
        for( int i=0 ; i<k ; ++i ){
            curr += nums[i] ; 
        }
        long[] dp = new long[n]; 
        dp[k-1] = curr ; 
        for( int i=k ; i<n ; ++i ){
            curr += nums[i] ; 
            curr -= nums[i-k] ;
            dp[i] = curr + Math.max( 0 , dp[i-k] ) ; 
        }
        long ans = dp[k-1] ; 
        for( int i=k-1 ; i<n ; ++i ){
            ans = Math.max( ans , dp[i] ) ; 
        }
        return ans ; 
    }
}