class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] f = new int[ 10 ] ; 
        while( n > 0 ){
            f[ n % 10 ]++  ;
            n /= 10 ; 
        }
        int best = 100 ; 
        int rs = -1 ; 
        for( int i=0 ; i<10 ; ++i) {
            if( f[i] > 0 && f[i] < best ){
                best = f[i] ;
                rs = i ; 
            }
        }
        return rs ; 
    }
}