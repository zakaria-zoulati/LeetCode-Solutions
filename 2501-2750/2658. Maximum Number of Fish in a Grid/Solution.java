class Solution {
    int n , m ; 
    static int[][] directions = {{-1,0} , {1,0} , {0,1} , {0,-1} } ; 
    public int findMaxFish(int[][] grid) {
        this.n = grid.length ; 
        this.m = grid[0].length ; 
        int rs = 0 ;
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] > 0 ){
                    rs = Math.max( rs , dfs( grid , i , j ) ) ; 
                }
            }
        }
        return rs ;  
    }
    public int dfs( int[][] g , int i , int j ){
        int rs = g[i][j] ; 
        g[i][j] = 0 ; 
        for( int[] d : directions ){
            int x = i + d[0] ; 
            int y = j + d[1] ; 
            if( x>=0 && y>=0 && x<n && y<m && g[x][y] > 0 ){
                rs += dfs(g,x,y) ; 
            }
        }
        return rs ; 
    }
}