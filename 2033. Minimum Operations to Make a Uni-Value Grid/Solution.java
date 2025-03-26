class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int mod = grid[0][0] % x ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] % x != mod ){
                    return -1 ; 
                }else {
                    grid[i][j] /= x ; 
                }
            }
        }
        int count = n*m ; 
        int[] list = new int[count] ;   
        int in = -1 ; 
        for( int[] i : grid ){
            for( int j : i ){
                list[++in] = j ; 
            }
        }
        Arrays.sort(list) ; 
        int mid = list[ count/2 ] ; 
        int rs = 0 ; 
        for( int[] i : grid ){
            for( int j : i ){
                rs += Math.abs( j - mid ) ; 
            }
        }
        return rs ; 
    }
}