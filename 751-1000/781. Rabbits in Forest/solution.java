class Solution {
    public int numRabbits(int[] answers) {
        int rs = 0 ; 
        int m = 0 ; 
        for( int i : answers ){
            m = Math.max( i , m ) ; 
        }
        int[] f = new int[m+1] ; 
        for( int i : answers ){
            ++f[i] ; 
        }
        for(int i=0 ; i<=m ; ++i ){
            while( f[i] >= i+1 ){
                f[i] -= i+1 ; 
                rs += i+1 ; 
            }
            if( f[i] != 0 ){
                rs += i+1 ; 
            }
        }
        return rs ; 
    }
}