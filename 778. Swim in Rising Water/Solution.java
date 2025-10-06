class Solution {
    static int[][] dirs = { {-1,0} , {1,0} , {0,1} , {0,-1} } ; 
    static int[][] s ; 
    static int in = -1 ; 
    public boolean check( int[][] grid , int n , int tar ){
        if( grid[0][0] > tar || grid[n-1][n-1] > tar ) return false ; 
        boolean[][] dp = new boolean[n][n] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                if( grid[i][j] <= tar ){
                    dp[i][j] = true ; 
                }
            }
        }
        s[0][0] = 0 ; 
        s[0][1] = 0 ;  
        in = 0 ; 
        dp[0][0] = false ; 
        while( in != -1 ){ 
            int[] curr = s[in--]; 
            int x = curr[0] ; 
            int y = curr[1] ;
            if( x == n-1 && y == n-1 ) return true ;  
            for( int[] dir : dirs ){
                int new_x = x + dir[0] ; 
                int new_y = y + dir[1] ;
                if( new_x>=0 && new_y>=0 && new_x<n && new_y<n && dp[new_x][new_y] ){
                    ++in ; 
                    s[in][0] = new_x; 
                    s[in][1] = new_y; 
                    dp[new_x][new_y] = false ; 
                } 
            }
        }
        return false ; 
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length ; 
        s = new int[n*n][2] ; 
        int l = 0 ; 
        int r = 2500;  
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            if( check( grid , n , mid ) ){
                r = mid ; 
            }else {
                l = mid + 1 ;
            }
        } 
        return l ; 
    }
}