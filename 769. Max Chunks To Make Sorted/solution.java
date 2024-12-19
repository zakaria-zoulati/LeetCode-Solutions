class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length ; 
        boolean[] f = new boolean[n] ; 
        int p = -1 ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            f[ arr[i] ] = true ; 
            while( p+1<n && f[p+1] ){
                ++p ; 
            }
            if( i == p ){
                rs++ ; 
            }
        }
        return rs ;
    }
}