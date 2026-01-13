class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        for(int i=0 ; i<n ; ++i){
            if( grid[i][0] == 0 ){
                for(int j=1 ; j<m ; ++j){
                    grid[i][j] ^= 1 ; 
                }
            }
        }
        int rs = n * (1 << (m-1)) ; 
        for(int j=1 ; j<m ; ++j){
            int cnt = 0 ; 
            for(int i=0 ; i<n ; ++i){
                cnt += grid[i][j] ;
            }
            if( cnt <= n/2  ){
               cnt = n - cnt ; 
            }
             rs += cnt*( 1 << (m-1-j) ) ; 
        }
        return rs ; 
    }
}