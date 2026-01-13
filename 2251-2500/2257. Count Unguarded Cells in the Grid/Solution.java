class Solution {
    int MIN = Integer.MIN_VALUE ; // The wall 
    int MAX = Integer.MAX_VALUE ; // The Guard
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        n = n + m ; 
        m = n - m ; 
        n -= m ;
        int[][] grid = new int[n][m] ; 
        for( int[] g : guards ){
            grid[ g[0] ][ g[1] ] = MAX ; 
        }
        for( int[] w : walls ){
            grid[ w[0] ][ w[1] ] = MIN ; 
        }
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == MAX ){
                    // left 
                    for( int k=j-1 ; k>=0 ; k-- ){
                        if( grid[i][k] == MAX || grid[i][k] == MIN ) break ; 
                        grid[i][k]-- ;
                    }
                    // right 
                    for( int k=j+1 ; k<m ; k++ ){
                        if( grid[i][k] == MAX || grid[i][k] == MIN ) break ; 
                        grid[i][k]-- ;
                    }
                    // up
                    for( int k=i-1 ; k>=0 ; k-- ){
                        if( grid[k][j] == MAX || grid[k][j] == MIN ) break ; 
                        grid[k][j]-- ;
                    }
                    // down 
                    for( int k=i+1 ; k<n ; ++k ){
                        if( grid[k][j] == MAX || grid[k][j] == MIN ) break ; 
                        grid[k][j]-- ;
                    }
                }
            }
        }
        int ans = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == 0 ) ans++ ; 
            }
        }
        return ans ;  
    }
}