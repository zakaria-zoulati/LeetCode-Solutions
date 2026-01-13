class Solution {
    int[] count ; 
    int n ;
    public int largestIsland(int[][] grid) {
        this.n = grid.length ; 
        int in = 2 ; 
        count = new int[n*n+3] ;  
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                dfs( i , j , grid  , in );
                ++in ; 
            }
        }
        int rs = 0 ; 
        for( int i=2 ; i<in ; ++i ){
            rs = Math.max( rs , count[i] ) ; 
        }
        boolean[] seen = new boolean[in];
        int up, down, left, right, merge;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    up = i > 0 ? grid[i - 1][j] : 0;
                    down = i + 1 < n ? grid[i + 1][j] : 0;
                    left = j > 0 ? grid[i][j - 1] : 0;
                    right = j + 1 < n ? grid[i][j + 1] : 0;
                    seen[up] = true;
                    merge = 1 + count[up];
                    if (!seen[down]) {
                        merge += count[down];
                        seen[down] = true;
                    }
                    if (!seen[left]) {
                        merge += count[left];
                        seen[left] = true;
                    }
                    if (!seen[right]) {
                        merge += count[right];
                        seen[right] = true;
                    }
                    rs = Math.max(rs, merge);
                    seen[up] = false;
                    seen[down] = false;
                    seen[left] = false;
                    seen[right] = false;
                }
            }
        }
        return rs;
    }
    public void dfs( int i , int j , int[][] g , int in ){
        if (i < 0 || i == n || j < 0 || j == n || g[i][j] != 1 ) return;
        g[i][j] = in ; 
        count[in]++ ; 
        dfs( i + 1, j , g , in);
        dfs( i - 1, j , g , in);
        dfs(i, j - 1 , g , in);
        dfs(i, j + 1 , g , in);
    }
}