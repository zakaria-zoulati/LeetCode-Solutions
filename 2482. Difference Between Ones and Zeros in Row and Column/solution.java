class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length ;
        int[] lines = new int[m] ; 
        int[] cols = new int[n] ;
        for(int i=0 ; i<m ; ++i){
            for(int j=0; j<n ; ++j){
                lines[i] += grid[i][j] ; 
            }
        } 
        for(int i=0 ; i<n ; ++i){
            for(int j=0; j<m ; ++j){
                cols[i] += grid[j][i] ; 
            }
        } 

        for(int i=0 ; i<m ; ++i){
            for(int j=0 ; j<n ; ++j){
                grid[i][j] = 2*lines[i] - m + 2*cols[j] - n ; 
            }
        }

        return grid  ;

    }
}