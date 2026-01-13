class Solution {
    int[][] directions = {{-1,0} , {1,0} , {0,-1} , {0,1}} ; 
    public int numIslands(char[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int rs = 0 ; 
        boolean[][] isSeen = new boolean[n][m] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == '1' && !isSeen[i][j] ){
                    dfs( isSeen , grid , i , j ) ; 
                    ++rs ; 
                }
            }
        }
        return rs ; 
    }
    public void dfs( boolean[][] isSeen , char[][] grid , int i , int j  ){
        int n = isSeen.length ; 
        int m = isSeen[0].length ; 
        isSeen[i][j] = true ; 
        for(int[] d : directions){
            int x = i+d[0] ; 
            int y = j+d[1] ;
            if( x>=0 && y>=0 && x<n && y<m && grid[x][y] == '1' && !isSeen[x][y]  ){
                dfs( isSeen , grid ,  x , y ) ; 
            }
        }
        
    }
}