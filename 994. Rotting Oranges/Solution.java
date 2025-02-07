class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int rs = 0 ; 
        int[][] dirs = { {-1,0} , {1,0} , {0,1} , {0,-1} } ; 
        Queue<int[]> q = new ArrayDeque<>() ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == 2 ){
                    grid[i][j] = 1 ; 
                    q.add( new int[]{i,j,0} ) ; 
                }
            }
        }
        while( !q.isEmpty() ){
            int[] curr = q.poll() ; 
            int i = curr[0] ; 
            int j = curr[1] ; 
            if( grid[i][j] != 1 ) continue ; 
            grid[i][j] = -1 ; 
            rs = Math.max( rs , curr[2] ) ; 
            for( int[] dir : dirs ){
                int x = i + dir[0] ; 
                int y = j + dir[1] ; 
                if( x>=0 && y>=0 && x<n && y<m && grid[x][y] == 1 ){
                    q.add( new int[]{ x , y , curr[2] + 1 } ) ; 
                }
            }
        }
        // Final Check 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == 1  ){
                    return -1 ; 
                }
            }
        }
        return rs ; 
    }
}