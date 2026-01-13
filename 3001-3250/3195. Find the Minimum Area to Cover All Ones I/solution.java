class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int r1 = n ; 
        int r2 = 0 ; 
        int c1 = m ; 
        int c2 = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            for(int j=0 ; j<m ; ++j){
                if( grid[i][j] == 1 ){
                    c1 = Math.min( c1 , j ) ;
                    c2 = Math.max( c2 , j ) ; 
                    r1 = Math.min( r1  , i ) ; 
                    r2 = i ; 
                }
            }
        }
        return ( r2 - r1 + 1 )*( c2 - c1 +1 ) ; 
    }
}