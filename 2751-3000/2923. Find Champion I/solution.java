class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length ;  
        all:for(int i=0 ; i<n ; ++i){
            for(int j=0; j<n ; ++j){
                if( grid[j][i] == 1 ){
                    continue all  ;  
                }
            }
            return i ; 
        }
        return -1 ; 
    }
}