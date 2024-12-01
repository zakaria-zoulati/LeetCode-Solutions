class Solution {
    int[][] dirs = { {-1,0},{1,0},{0,1},{0,-1} } ; 
    int n , m ; 
    public int dfs( int[][] g , int i , int j , boolean[][] isSeen ){
        isSeen[i][j] = true ; 
        int curr = 1 ;
        for( int[] d : dirs ){
            int x = i+d[0]; 
            int y = j+d[1]; 
            if( x>=0 && x<n && y>=0 && y<m && g[x][y]==1 && !isSeen[x][y] ){
                curr += dfs( g,x,y,isSeen ) ;
            }
        }
        return curr ; 
    } 
    public int maxAreaOfIsland(int[][] g) {
        int rs = 0 ; 
        n = g.length ; 
        m = g[0].length ; 
        boolean[][] isSeen = new boolean[n][m] ; 
        for(int i=0 ; i<n ; ++i){
            for( int j=0 ; j<m ; ++j ){
                if( g[i][j]==1 && !isSeen[i][j] ){
                    rs = Math.max( rs , dfs( g , i , j , isSeen )) ;
                }
            }   
        }
        return rs ; 
    }
}