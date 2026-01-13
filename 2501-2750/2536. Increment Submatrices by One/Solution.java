class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n] ; 
        for( int[] q : queries ){
            int r0 = q[0] ; 
            int c0 = q[1] ; 
            int r1 = q[2]+1 ; 
            int c1 = q[3]+1 ; 
            ans[r0][c0]++ ; 
            if( c1<n ) ans[r0][c1]-- ; 
            if( r1<n ){
                ans[r1][c0]-- ; 
                if( c1<n ) ans[r1][c1]++ ; 
            } 
        }
        for( int i=0 ; i<n ; ++i ){
            for( int j=1 ; j<n ; ++j ){
                ans[i][j] += ans[i][j-1] ; 
            }
        }
        for( int j=0 ; j<n ; ++j ){
            for( int i=1 ; i<n ; ++i ){
                ans[i][j] += ans[i-1][j] ; 
            }
        }
        return ans; 
    }
}