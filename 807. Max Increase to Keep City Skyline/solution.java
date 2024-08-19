class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length ; 
        int[] lines = new int[n] ;
        int[] cols = new int[n] ; 
        for(int i=0 ; i<n ; ++i){
            int max = 0 ; 
            for(int j=0 ; j<n ; ++j){
                max = Math.max( grid[i][j] , max ) ;
            }
            lines[i] = max ; 
        }
        for(int i=0 ; i<n ; ++i){
            int max = 0 ; 
            for(int j=0 ; j<n ; ++j){
                max = Math.max( grid[j][i] , max ) ;
            }
            cols[i] = max ; 
        }
        int rs = 0  ;
        for(int i=0 ; i<n ; ++i){
            for(int j=0; j<n ; ++j){
                    int a= Math.min( lines[i] , cols[j] ) ; 
                    if( grid[i][j] < a ){
                        rs += a - grid[i][j] ; 
                    }
            }
        }

        return rs ; 
    }
}