class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length ; 
        int m = grid[0].length ;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        ); 
        
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                    pq.add( new int[]{ grid[i][j] , i } ) ; 
            }
        }
        long rs = 0L  ;
        while( k > 0 && !pq.isEmpty() ){
            int[] curr = pq.poll() ; 
            if( limits[ curr[1] ]-- > 0 ){
                k-- ; 
                rs += curr[0] ; 
            }
        }
        return rs ; 
    }
}