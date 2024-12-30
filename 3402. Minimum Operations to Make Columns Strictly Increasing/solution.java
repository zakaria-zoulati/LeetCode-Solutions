class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int rs = 0 ; 
        for( int i=0 ;i<m ; ++i ){
            int curr = grid[0][i] ; 
            for( int j=1 ; j<n ; ++j ){
                if( grid[j][i] <= curr ){
                    rs += curr++ - grid[j][i] + 1; 
                }else {
                    curr = grid[j][i] ; 
                }
            }
        }
        return rs ;
    }
}