class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        for(int i=0 ; i<n; ++i){
            for(int j=0 ; j<m ; ++j){
                if( j+1<m && grid[i][j] == grid[i][j+1] ) return false ;
                if( i+1<n && grid[i+1][j] != grid[i][j] ) return false ;
            }
        }
        return true ;
    }
}