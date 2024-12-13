class Solution {
    int rs = 0 ; 
    public int numTilePossibilities(String tiles) {
        int[] f = new int[26] ; 
        for( char c : tiles.toCharArray() ){
            f[c - 'A']++ ; 
        } 
        for( int i=0 ; i<26 ; ++i ){
            if( f[i] > 0 ){
                backtrack( f , i ) ; 
            }
        } 
        return rs ; 
    }
    public void backtrack( int[] f , int in ){
        --f[in] ; 
        ++rs ; 
        for( int i=0 ; i<26 ; ++i ){
            if( f[i] > 0 ){
                backtrack( f , i ) ; 
            }
        }
        ++f[in] ; 
    }
}