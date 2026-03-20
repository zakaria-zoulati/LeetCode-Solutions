class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int[][] ans = new int[n-k+1][m-k+1] ;
        if( k == 1 ){
            return ans ; 
        }
        int[] curr = new int[k*k] ; 
        int in = 0 ; 
        for( int i=0 ; i<=n-k ; ++i ){
            for( int j=0 ; j<=m-k ; ++j ){
                for( int l=0 ; l<k ; ++l ){
                    for( int r=0 ; r<k ; ++r ){
                        curr[in++] = grid[i+l][j+r] ;  
                    }
                }
                Arrays.sort( curr ) ; 
                int val = Integer.MAX_VALUE ; 
                for( int t=1 ; t<k*k ; ++t ){
                    if( curr[t] != curr[t-1] ){
                        val = Math.min( val , curr[t] - curr[t-1] ) ; 
                    }
                }
                ans[i][j] = val == Integer.MAX_VALUE ? 0 : val ; 
                in = 0 ; 
            }
        }
        return ans ;  
    }
}