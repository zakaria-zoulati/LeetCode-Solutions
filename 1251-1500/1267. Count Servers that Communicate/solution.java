class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int rs = 0 ; 
        int[][] rep = new int[n][m] ; 
        int[] rows = new int[n] ; 
        int[] cols = new int[m] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0; j<m ; ++j ){
                if( grid[i][j] == 1 ){
                    rows[i]++ ; 
                    cols[j]++ ; 
                }
            }
        }
        // Add all the rows
        for( int i=0 ; i<n ; ++i ){
            if( rows[i] > 1 ){
                rs += rows[i] ; 
            }
        }
        // Add all the columns 
        for( int j=0 ; j<m ; ++j ){
            if( cols[j] > 1 ){
                rs += cols[j] ; 
            }
        }
        // Delete The redundanr elements 
        for( int i=0 ; i<n ; ++i ){
            if( rows[i] > 1 ){
                for( int j=0 ; j<m ; ++j ){
                    if( grid[i][j] == 1 && cols[j] > 1 ){
                        rs-- ; 
                    }
                }
            }
        }
        return rs ;
    }
}