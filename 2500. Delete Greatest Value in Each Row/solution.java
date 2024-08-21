class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length ; 
        for(int i=0 ; i<m ; ++i){
            Arrays.sort( grid[i] ) ; 
        }
        int rs = 0 ;
        for(int i=0 ;i<n ; ++i){
            int curr  = 0 ; 
            for(int j=0 ; j<m ; ++j){
                curr = Math.max( curr , grid[j][i] ) ;
            }
            rs += curr ;
        }
        return rs ; 

    }
}