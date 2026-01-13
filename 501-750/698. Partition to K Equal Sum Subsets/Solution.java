class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if( k == 1 ) return true ; 
        int n = nums.length ; 
        int sum = 0 ; 
        for( int i : nums ) {
            sum += i ; 
        }
        if( sum % k != 0 ) return false ; 
        int tar = sum/k ; 
        int all = ( 1 << n ) - 1; 
        int[] dp = new int[all+1] ; 
        for( int i=1 ; i<=all ; ++i ){
            int curr = 0 ;
            for( int j = 0 ; j<n ; ++j ){
                if( ( i & ( 1<<j ) ) > 0 ){
                    dp[i] = Math.max( dp[i] , dp[i^(1<<j)] ); 
                    curr += nums[j] ;
                }
            }
            if( curr % tar == 0 ){
                dp[i]++ ; 
            }
        }
        return dp[all] == k ; 
    }
}