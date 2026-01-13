class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0 ; 
        int n = prices.length ; 
        for( int i=0 ; i<n ; ++i ){
            long curr = 1;
            while( i+1<n && prices[i+1] == prices[i] - 1 ){
                i++ ; 
                curr++ ; 
            }
            ans += curr*(curr+1)/2 ; 
        }
        return ans ; 
    }
}