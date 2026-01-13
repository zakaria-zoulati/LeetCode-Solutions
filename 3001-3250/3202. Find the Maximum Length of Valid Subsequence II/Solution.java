class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k] ;
        int rs = 2 ;  
        for( int num : nums ){
            int s = num % k ;  
            for( int i=0 ; i<k ; ++i ){
                dp[i][s] = dp[s][i] + 1 ; 
                if( dp[i][s] > rs ) rs = dp[i][s] ; 
            }
        }
        return rs ; 
    }
}