class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length ; 
        long line1 = -grid[0][0] ; 
        long line2 = 0L ; 
        for( int i : grid[0] ){
            line1 += i  ; 
        }
        long rs = line1 ; 
        for( int i=1 ; i<n ; ++i ){
            line1 -= grid[0][i] ; 
            line2 += grid[1][i-1] ; 
            long m =  Math.max( line1 , line2 ) ; 
            if( m < rs ){
                rs = m ; 
            }  
        }
        return rs ; 
    }
}