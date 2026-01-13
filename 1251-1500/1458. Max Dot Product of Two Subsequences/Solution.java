class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length ; 
        int m = nums2.length ; 
        int[][] dp = new int[n][m] ; 
        dp[n-1][m-1] = nums1[n-1]*nums2[m-1] ; 
        for( int i=n-2 ; i>=0 ; --i ){
            dp[i][m-1] =  Math.max(nums1[i]*nums2[m-1] , dp[i+1][m-1] ) ; 
        }
        for( int i=m-2 ; i>=0 ; --i ){
            dp[n-1][i] = Math.max( nums1[n-1]*nums2[i] , dp[n-1][i+1] ) ; 
        }
        for( int i=n-2 ; i>=0 ; --i ){
            for( int j=m-2 ; j>=0 ; --j ){
                dp[i][j] = Math.max( dp[i+1][j+1] , nums1[i]*nums2[j] + Math.max( 0 , dp[i+1][j+1] ) ) ; 
                dp[i][j] = Math.max( dp[i][j] , Math.max( dp[i][j+1] , dp[i+1][j] )) ; 
            }
        }
        return dp[0][0] ;  
    }
}