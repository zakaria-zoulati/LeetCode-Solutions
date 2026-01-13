class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length ; 
        int m = nums[0] ; 
        for( int num : nums ) if( num > m ) m = num ;  
        if( m == 1 ) return n ; 
        int[] f = new int[m+1] ;
        for( int num : nums ){
            f[num]++ ;
        }
        int[] dp = new int[m+1] ;
        dp[1] = f[1] ;  
        for( int i=2 ; i<=m ; ++i ){
            dp[i] = Math.max( dp[i-1] , dp[i-2] + i*f[i] ) ; 
        }
        return dp[m] ; 
    }
}