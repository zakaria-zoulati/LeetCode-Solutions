class Solution {
    int[] count ; 
    int n ;
    static Set<Integer> set = new HashSet<>() ; 
    static int[][] dirs = { {-1,0} , {1,0} , {0,1} , {0,-1} } ; 
    public int largestIsland(int[][] grid) {
        this.n = grid.length ; 
        int in = 1 ; 
        int[][] rep = new int[n][n] ;
        count = new int[250*n+1] ;  
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                if( grid[i][j] == 1 && rep[i][j] == 0 ){
                    dfs( i , j , grid , rep , in );
                    in++ ; 
                }
            }
        }
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for(int j=0 ; j<n ; ++j){
                if( grid[i][j] == 0 ){
                    rs = Math.max( rs , check(i,j,grid,rep) ) ; 
                }
            }
        }
        if( rs == 0 ){
            return n*n ;
        }
        return rs ; 
    }
    public void dfs( int i , int j , int[][] g , int[][] rep , int in ){
        rep[i][j] = in ; 
        count[in]++ ; 
        for( int[] d : dirs ){
            int x = i+d[0] ; 
            int y = j+d[1] ; 
            if( x>=0 && y>=0 && x<n && y<n && g[x][y] == 1 && rep[x][y] == 0 ){
                dfs( x , y , g , rep , in ) ; 
            }
        }
    }
    public int check( int i , int j , int[][] g , int[][] rep ){
        int curr = 1 ; 
        for( int[] d : dirs ){
            int x = i+d[0] ; 
            int y = j+d[1] ; 
            if( x>=0 && y>=0 && x<n && y<n && g[x][y] == 1  ){
                set.add( rep[x][y] ) ; 
            }
        }
        for( int in : set ){
            curr += count[in] ; 
        }
        set.clear() ; 
        return curr ;
    }
}