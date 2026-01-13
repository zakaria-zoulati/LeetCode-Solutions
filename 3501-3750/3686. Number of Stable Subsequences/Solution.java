class Solution {
    public int countStableSubsequences(int[] nums) {
      int n = nums.length ; 
      long mod = 1_000_000_007 ; 
      long[][] dp = new long[2][3] ; 
      for( int i=0 ; i<n ; ++i ){
          if( nums[i] % 2 == 0 ){
              dp[0][2] = ( dp[0][2] + dp[0][1] ) % mod ;  
              dp[0][1] = ( dp[0][1] + 1 ) % mod ; 
              dp[0][1] = ( dp[0][1] + dp[1][1] + dp[1][2] ) % mod ; 
          }else {
              dp[1][2] = ( dp[1][2] + dp[1][1] ) % mod ; 
              dp[1][1] = ( dp[1][1] + 1 ) % mod ; 
              dp[1][1] = ( dp[1][1] + dp[0][1] + dp[0][2] ) % mod ; 
          }
      } 
      long rs = 0 ; 
      for( int i=0 ;i<2 ; ++i ){
          for( int j=1 ; j<3 ; ++j ){
              rs = ( rs + dp[i][j] ) % mod ; 
          }
      }  
      return (int) rs ; 
    }
}