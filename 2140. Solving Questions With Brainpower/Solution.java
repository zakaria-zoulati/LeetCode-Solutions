class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length ;  
        long[] dp = new long[n] ; 
        dp[n-1] = q[n-1][0] ; 
        for(int i=n-2 ; i>=0 ; --i ){
            int next = i+q[i][1]+1 ; 
            long sol = q[i][0]+(next<n?dp[next]:0); 
            dp[i] = Math.max(dp[i+1],sol) ; 
        }
        return dp[0] ; 
    }
}