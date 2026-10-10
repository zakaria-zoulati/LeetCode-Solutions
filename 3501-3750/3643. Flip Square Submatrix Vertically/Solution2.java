class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for( int i=0 ; i<k ; ++i ){
            int l = x ; 
            int r = x + k-1 ; 
            while( l < r ){
                int temp = grid[l][y+i] ; 
                grid[l][y+i] = grid[r][y+i] ; 
                grid[r][y+i] = temp ; 
                l++ ; 
                r-- ; 
            } 
        }
        return grid ; 
    }
}