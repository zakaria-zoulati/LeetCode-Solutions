class Solution {
    public int rob(int[] nums) {
        int n = nums.length ; 
        if( n == 1 ){
            return nums[0] ; 
        }
        if( n == 2 ){
            return Math.max( nums[0] , nums[1] ) ; 
        }
        if( n == 3 ){
            return Math.max( nums[0] + nums[2] , nums[1] ) ; 
        }
        int[] dp = new int[n] ; 
        dp[0] = nums[0] ; 
        dp[1] = nums[1] ; 
        dp[2] = nums[0] + nums[2] ; 
        for(int i=3 ; i<n ; ++i){
            dp[i] = nums[i] + Math.max( dp[i-2]  , dp[i-3] ) ; 
        }
        return Math.max(  dp[n-1] , dp[n-2] ) ; 
    }
}