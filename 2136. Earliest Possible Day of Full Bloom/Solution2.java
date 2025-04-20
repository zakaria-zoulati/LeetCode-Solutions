class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length ; 
        int[] x = new int[10_001]; 
        for( int i=0 ; i<n ; ++i ){
            x[ growTime[i] ] += plantTime[i] ; 
        }
        int curr = 0 ; 
        int m = 0 ; 
        for( int i=10_000 ; i>=1 ; --i ){
            if( x[i] == 0 ) continue ; 
            curr += x[i] ; 
            m = Math.max( curr + i , m ) ; 
        }
        return m ; 
    }
}