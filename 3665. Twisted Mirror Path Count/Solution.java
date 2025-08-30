class Solution {
    int n , m ; 
    int[][] grid ; 
    int[][][] dp ; 
    int[][][][] go ; 
    // The 0 is coming from left 
    // The 1 is coming from the top
    int mod = 1_000_000_007 ; 
    int[] helper( int i , int j ,int dir ){
        if( i>=n || j>=m ){
            return new int[]{-1,-1} ; 
        }
        if( grid[i][j] == 0 ){
            return new int[]{i,j} ; 
        } 
        return go[i][j][dir] ; 
    }
    public int uniquePaths(int[][] grid) {
        this.n = grid.length ; 
        this.m = grid[0].length ;  
        this.grid = grid ; 
        this.dp = new int[n][m][2] ; 
        this.go = new int[n][m][2][2] ; 
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=m-1 ; j>=0 ; --j ){
                if( grid[i][j] == 1 ){
                    go[i][j][0] = helper( i+1, j , 1 ) ; 
                    go[i][j][1] = helper( i , j+1 , 0 ) ; 
                }
            }
        }
        dp[0][0][0] = 1 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == 0 ){
                    int curr = ( dp[i][j][0] + dp[i][j][1] ) % mod ; 
                    if( i+1<n ){
                        dp[i+1][j][1] = ( dp[i+1][j][1] + curr ) % mod ; 
                    }
                    if( j+1<m ){
                        dp[i][j+1][0] = ( dp[i][j+1][0] + curr ) % mod ; 
                    }
                }else {
                    int[] pos = go[i][j][0] ; 
                    if( pos[0] != -1){
                        int x = pos[0];
                        int y = pos[1] ; 
                        dp[x][y][1] = ( dp[x][y][1] + dp[i][j][0] ) % mod ; 
                    }
                    pos = go[i][j][1] ; 
                    if( pos[0] != -1){
                        int x = pos[0];
                        int y = pos[1] ; 
                        dp[x][y][0] = ( dp[x][y][0] + dp[i][j][1] ) % mod ; 
                    }
                }
            }
        }
        int rs = ( dp[n-1][m-1][0] + dp[n-1][m-1][1] ) % mod ;
        return rs ; 
    }
}