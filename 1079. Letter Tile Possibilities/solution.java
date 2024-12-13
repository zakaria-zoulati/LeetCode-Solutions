class Solution {
    int rs = 0 ; 
    public int numTilePossibilities(String tiles) {
        int[] f = new int[26] ; 
        for( char c : tiles.toCharArray() ){
            f[ c - 'A']++ ; 
        } 
        for( int i=0 ; i<26 ; ++i ){
            backtrack( f , i ) ; 
        } 
        return rs ; 
    }
    public void backtrack( int[] f , int in ){
        if( f[in] == 0 ) return ; 
        f[in]-- ; 
        rs += 1 ; 
        for( int i=0 ; i<26 ; ++i ){
            backtrack( f , i ) ; 
        }
        f[in]++ ; 
    }
}