class Solution {
    int MOD = 12345 ; 
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 

        int zeros = 0 ; 

        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                grid[i][j] %= MOD ; 
                if( grid[i][j] == 0 ) ++zeros ; 
            }
        }

        if( zeros > 1 ) return new int[n][m] ; 

        int[][] ans = new int[n][m] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                ans[i][j] = 1 ; 
            }
        } 

        int p = 1 ; 
        int s = 1 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                ans[i][j] = ( ans[i][j] * p ) % MOD ; 
                p = ( p * grid[i][j] ) % MOD ; 
                ans[n-1-i][m-1-j] = ( ans[n-1-i][m-1-j] * s ) % MOD ; 
                s = ( s * grid[n-1-i][m-1-j] ) % MOD ; 
            }
        }

        return ans ; 
    }
}