class Solution {
    public int findLucky(int[] arr) {
        int[] f = new int[501] ; 
        for( int i : arr ) f[i]++ ; 
        int rs = - 1; 
        for( int i=1 ; i<=500 ; ++i ){
            if( f[i] == i ) rs = i ;
        }
        return rs ; 
    }
}