class Solution {
    public int minArrivalsToDiscard(int[] arr, int w, int m) {
        int n = arr.length ; 
        int[] f = new int[100_001] ; 
        int rs = 0 ; 
        boolean[] t = new boolean[n] ; 
        for( int i=0 ; i<w ; ++i ){
            if( ++f[ arr[i] ] > m ){
                f[arr[i]]-- ; 
                t[ i ] = true ; 
                rs++ ; 
            }
        }
        for( int i=w ; i<n ; ++i ){
            if( !t[i-w] ){
                f[ arr[i-w] ]-- ; 
            }
            if( ++f[ arr[i] ] > m ){
                rs++ ; 
                t[ i ] = true ; 
                f[ arr[i] ]-- ; 
            }
        }
        return rs ; 
    }
}