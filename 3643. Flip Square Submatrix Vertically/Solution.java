class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int[][] rs = new int[n][m] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0  ; j<m ; ++j ){
                rs[i][j] = grid[i][j] ; 
            }
        }
        for( int i=0 ;i<k ; ++i ){
            for( int j=0 ; j<k ; ++j ){
                rs[x+i][y+j] = grid[x+k-1-i][y+j] ; 
            }
        }

        return rs ; 
    }
}