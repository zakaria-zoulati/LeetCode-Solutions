class Solution {
    int rs = 0 ; 
    public int numTilePossibilities(String tiles) {
        int[] inter = new int[26] ; 
        int all = 0 ; 
        for( char c : tiles.toCharArray() ){
            if( inter[c-'A']++ == 0 ) all++ ; 
        }
        int[] f = new int[all] ; 
        int in = 0 ;
        for( int i : inter ){
            if( i > 0 ){
                f[in++] = i ; 
            }
        }
        for( int i=0 ; i<all ; ++i ){
            if( f[i] > 0 ){
                backtrack( f , i ) ; 
            }
        } 
        return rs ; 
    }
    public void backtrack( int[] f , int in ){
        --f[in] ; 
        ++rs ; 
        for( int i=0 ; i<f.length ; ++i ){
            if( f[i] > 0 ){
                backtrack( f , i ) ; 
            }
        }
        ++f[in] ; 
    }
}