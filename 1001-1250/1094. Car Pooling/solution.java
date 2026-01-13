class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] x = new int[1_001] ; 
        for( int[] trip : trips ){
           x[ trip[1] ] += trip[0] ; 
           x[ trip[2] ] -= trip[0] ; 
        }
        int curr = 0 ; 
        for(int i : x ){
            if ( (curr += i ) > c)return false; 
        }
        return true  ;
    }
}