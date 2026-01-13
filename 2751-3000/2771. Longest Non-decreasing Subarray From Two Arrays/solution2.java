class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
       int n = nums1.length ; 
       int[][] dp = new int[n][2] ; 
       dp[0] = new int[2] ; 
       dp[0][0] = 1 ; 
       dp[0][1] = 1 ;
       int rs = 1  ;
       for(int i=1 ; i<n ; ++i){
            dp[i] = new int[2] ; 
            int min = Math.min( nums1[i] , nums2[i] ) ;
            int max = Math.max( nums1[i] , nums2[i] ) ;
            int min_p = Math.min( nums1[i-1] , nums2[i-1] ) ;
            int max_p = Math.max( nums1[i-1] , nums2[i-1] ) ;
            if( min >= max_p ){
                dp[i][0] = Math.max( dp[i-1][0] , dp[i-1][1] ) + 1 ; 
                dp[i][1] = Math.max( dp[i-1][0] , dp[i-1][1] ) + 1 ; 
                rs = Math.max( rs , dp[i][0] ) ; 
                rs = Math.max( rs , dp[i][1] ) ; 
                continue  ;
            }else if( min >= min_p ){
                dp[i][0] = dp[i-1][0] + 1 ; 
            }else {
                dp[i][0] = 1 ; 
            }

            if( max >= max_p ){
                dp[i][1] = Math.max( dp[i-1][0] , dp[i-1][1] ) + 1 ; 
            }else if( max >= min_p ){
                dp[i][1] = dp[i-1][0] + 1 ; 
            }else {
                dp[i][1] = 1 ; 
            }
            rs = Math.max( rs , dp[i][0] ) ; 
            rs = Math.max( rs , dp[i][1] ) ; 
       }
       return rs ; 
    }
}