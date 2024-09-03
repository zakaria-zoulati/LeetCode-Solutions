class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort( pairs , (a,b) -> a[1] - b[1] ) ; 
        int n = pairs.length ; 
        int rs = 0 ; 
        int[] dp = new int[n] ;
        dp[0] = 1; 
        int curr = pairs[0][1] ; 
        for(int i=1 ; i<n ; ++i){
            dp[i] += dp[i-1] ; 
            if( pairs[i][0] > curr ) {
                curr = pairs[i][1] ; 
                dp[i]++ ;
            }
        }
        return dp[n-1]  ;
    }
}