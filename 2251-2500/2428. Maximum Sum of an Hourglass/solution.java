class Solution {
    public int maxSum(int[][] grid) {
        int m = grid[0].length ; 
        int n = grid.length ; 
        int rs = 0  ; 
        for(int i=0 ; i<n ; ++i){
            for(int j=1 ; j<m ;++j){
                grid[i][j] += grid[i][j-1] ; 
            }
        }
        for(int i=0 ; i+2<n ; ++i){
            for(int j=0 ; j+2<m ; ++j){
                rs = Math.max( rs , grid[i][j+2] + grid[i+1][j+1] - grid[i+1][j] + grid[i+2][j+2] - ( j-1>=0 ?  grid[i][j-1] + grid[i+2][j-1]  : 0 ) ) ; 
            }
        }
        return rs ; 
    }
}