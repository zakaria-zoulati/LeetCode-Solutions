class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] win = new int[n] ; 
        for( int[] e : edges ){
            win[ e[1] ] += 1 ; 
        }
        int c = 0 ; 
        int w = -1 ;
        for( int i=0 ; i<n ; ++i ){
            if( win[i] == 0 ){
                ++c ; 
                w = i ; 
            }
        }
        if( c==1 ) return w ;
        return -1 ;
    }
}