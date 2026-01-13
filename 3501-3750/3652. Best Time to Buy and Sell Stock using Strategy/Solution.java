class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length ; 
        long sum = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            sum += strategy[i]*prices[i] ; 
        }
        long rs = sum ; 
        long[] prefix = new long[n+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            prefix[i] = prefix[i-1] + strategy[i-1]*prices[i-1] ; 
        }
        long[] pos = new long[n+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            pos[i] = pos[i-1] + Math.abs( prices[i-1] ) ; 
        }
        for( int i=k ; i<=n ; ++i ){
            rs = Math.max( rs , sum - prefix[i] + prefix[i-k] + pos[i] - pos[i-k/2] ) ; 
        }
        
        return rs ; 
    }
}