class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        long sum = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                sum += grid[i][j] ; 
            }
        } 
        if( sum % 2 == 1 ) return false ; 
        long h = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                h += grid[i][j] ; 
            }
            if( h * 2 == sum ) return true ; 
            if( h * 2 > sum ) break ; 
        }
        long v = 0 ; 
        for( int j=0 ; j<m ; ++j ){
            for( int i=0 ; i<n ; ++i ){
                v += grid[i][j] ; 
            } 
            if( v * 2 > sum ) break ; 
            if( v * 2 == sum ) return true ; 
        }
        return false ; 
    }
}