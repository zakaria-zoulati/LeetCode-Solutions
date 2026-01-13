class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length ; 
        int[] rs = new int[n] ; 
        for( int i=n-1 ; i>=0 ; --i ){
            rs[i] = cost[i] ; 
            for( int j=0 ; j<i ; ++j ){
                rs[i] = Math.min( rs[i] , cost[j] ) ; 
            }
        }
        return rs ; 
    }
}