class Solution {
    public int check( int target ,int[] tops , int[] bottoms ){
        int n = tops.length ; 
        int sol1 = 0 ; 
        int sol2 = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( tops[i] != target && bottoms[i] != target ) return -1   ;
            if( tops[i] != target ) sol1++ ; 
            if( bottoms[i] != target ) sol2++ ; 
        }
        return Math.min( sol1 , sol2 ) ; 
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rs = -1 ; 
        for( int i=1 ; i<7 ; ++i ){
            int curr = check( i , tops , bottoms ) ; 
            if( curr != -1 ){
                if( rs == -1 || curr < rs ){
                    rs = curr ; 
                }
            }
        }
        return rs ; 
    }
}