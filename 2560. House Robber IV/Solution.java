class Solution {
    public boolean isPossible( int[] nums , int tar , int k ){
        int n = nums.length ; 
        // Try to get the longest subsequence that contains elments below the target
        int[] dp = new int[n] ; 
        int max = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] <= tar ){
                dp[i] = 1 ; 
                if( i >= 2  ){
                    dp[i] = 1 + dp[i-2] ; 
                }
                max = Math.max( dp[i] , max ) ; 
            }else if( i >= 1 ) {
                dp[i] = dp[i-1] ; 
            }   
        }
        return max >= k ; 
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length ; 
        int l = 1 ; 
        int r = 1_000_000_000 ; 
        int max = -1 ; 
        for( int i : nums ){
            max = Math.max( max , i ) ; 
        }
        r = max ; 
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            if( isPossible( nums , mid , k ) ){
                r = mid ; 
            }else {
                l = mid+1 ; 
            }
        }   
        return l ; 
    }
}