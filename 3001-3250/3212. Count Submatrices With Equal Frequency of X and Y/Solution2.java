class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        
        int ans = 0 ; 
        int[] colX = new int[n] ;
        int[] colY = new int[n] ;

        for( int j=0 ; j<m ; ++j ){
            for( int i=0 ; i<n ; ++i ){
                if( grid[i][j] == 'X' ) colX[i]++ ; 
                else if( grid[i][j] == 'Y' ) colY[i]++ ; 
            }

            int x = 0 , y = 0 ; 
            for( int i=0 ; i<n; ++i ){
                x += colX[i] ; 
                y += colY[i] ; 
                if( x == y && x > 0 ) ans++ ; 
            }
        }
        return ans ; 
    }
}