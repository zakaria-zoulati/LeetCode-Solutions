class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int[][] map = new int[m*n+1][2] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                map[ mat[i][j] ][0] = i ; 
                map[ mat[i][j] ][1] = j ;
            }
        } 
        int[] rows = new int[n] ; 
        int[] cols = new int[m] ; 
        for( int i=0 ;; ++i ){
            int[] curr = map[ arr[i] ] ; 
            if( ++rows[ curr[0] ] == m || ++cols[ curr[1] ] == n ){
                return i ; 
            }
        }
    }
}