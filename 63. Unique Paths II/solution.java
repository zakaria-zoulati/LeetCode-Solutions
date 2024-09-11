class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length ; 
        if( grid[0][0] == 1 || grid[m-1][n-1] == 1 ){
            return 0 ; 
        }else {
            grid[0][0] = 1 ; 
        }
        for(int j=1 ; j<n ; ++j){
                if( grid[0][j] == 1 ){
                    grid[0][j] = -1 ; 
                    continue ;
                }
                if( j-1 >=0 &&  grid[0][j-1] != -1  ){
                    grid[0][j] += (j - 1 >= 0 && grid[0][j - 1] != -1 ) ? grid[0][j - 1] : 0;
                }
                else {
                    grid[0][j] = -1 ; 
                }
        }
        for(int i=1 ; i<m ; ++i ){
            for(int j=0 ; j<n ; ++j){
                if( grid[i][j] == 1 ){
                    grid[i][j] = -1;
                    continue ;
                }
                if( j-1 >=0 && grid[i][j-1] != -1 ||  i-1>=0 && grid[i-1][j] != -1 ){
                    grid[i][j] += (i - 1 >= 0 && grid[i - 1][j] != -1 ) ? grid[i - 1][j] : 0;
                    grid[i][j] += (j - 1 >= 0 && grid[i][j - 1] != -1 ) ? grid[i][j - 1] : 0;
                }
                else {
                    grid[i][j] = -1 ; 
                }
            }
        }
        if( grid[m-1][n-1] == -1  ){
            return 0 ; 
        } 
        return grid[m-1][n-1] ; 
    }
}
