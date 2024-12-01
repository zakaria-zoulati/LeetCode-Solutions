class Solution {
    int[][] directions = { {-1,0} , {1,0} , {0,1} , {0,-1} } ; 
    int n , m ; 
    public int dfs( int[][] grid , int i , int j , boolean[][] isSeen ){
        isSeen[i][j] = true ; 
        int curr = 1 ;
        for( int[] d : directions ){
            int x = i + d[0] ; 
            int y = j + d[1] ; 
            if( x>=0 && x<n && y>=0 && y<m && grid[x][y] == 1 && !isSeen[x][y] ){
                curr += dfs( grid , x , y , isSeen ) ;
            }
        }
        return curr ; 
    } 
    public int maxAreaOfIsland(int[][] grid) {
        int rs = 0 ; 
        n = grid.length ; 
        m = grid[0].length ; 
        boolean[][] isSeen = new boolean[n][m] ; 
        for(int i=0 ; i<n ; ++i){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == 1 && !isSeen[i][j] ){
                    rs = Math.max( rs , dfs( grid , i , j , isSeen ) ) ;
                }
            }   
        }
        return rs ; 
    }
}