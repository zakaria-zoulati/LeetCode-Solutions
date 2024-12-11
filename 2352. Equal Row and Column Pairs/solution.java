class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            h:for( int j=0 ; j<n ; ++j ){
                for( int k=0 ; k<n ; ++k ){
                    if( grid[i][k] != grid[k][j] ){
                        continue h ; 
                    }
                }
                rs++ ; 
            }
        }
        return rs ; 
    }
}