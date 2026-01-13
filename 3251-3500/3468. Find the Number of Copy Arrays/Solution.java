class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n  = original.length ; 
        // The Start Can be between the 
        int u = bounds[0][0] ; 
        int v = bounds[0][1] ; 
        for( int i=1 ; i<n ; ++i ){
            int diff = original[i] - original[i-1] ; 
            u += diff ; 
            v += diff ; 
            u = Math.max( u , bounds[i][0] ) ;
            v = Math.min( v , bounds[i][1] ) ; 
        }
        int rs = v - u + 1 ; 
        if( rs >= 0  ){
            return rs ; 
        }
        return 0 ; 
    }
}