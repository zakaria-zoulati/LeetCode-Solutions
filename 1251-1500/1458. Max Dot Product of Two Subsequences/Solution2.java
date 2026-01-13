class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length ; 
        int m = nums2.length ; 
        int[][] dp = new int[n+1][m+1] ;
        int mi = Integer.MIN_VALUE ; 
        for( int i=0 ; i<=n ; ++i ){
            dp[i][m] = mi ; 
        }
        for( int i=0 ; i<m ; ++i ){
            dp[n][i] = mi ; 
        }
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=m-1 ; j>=0 ; --j ){
                dp[i][j] = nums1[i]*nums2[j] + Math.max(0,dp[i+1][j+1] ) ;  
                dp[i][j] = Math.max( dp[i][j] , Math.max( dp[i][j+1] , dp[i+1][j] ) ) ; 
            }
        }
        return dp[0][0] ;  
    }
}