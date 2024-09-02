class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length ; 
        int m = queries.length ; 
        int[] dp = new int[n] ; 
        boolean[] rs = new boolean[m] ; 
        dp[0] = 1 ; 
        for(int i=1 ; i<n ; ++i){
            if( ( nums[i] - nums[i-1] ) % 2 == 0 ){
                dp[i] = 1 ;
            }else {
                dp[i] = dp[i-1] + 1 ; 
            } 
        }

        for(int i=0 ; i<m ; ++i){
            int elements = queries[i][1] - queries[i][0] + 1; 
            if( dp[ queries[i][1] ] >= elements ) rs[i] = true ; 
        }

        return rs ; 

    }
}