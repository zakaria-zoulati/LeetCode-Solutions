class Solution {
    int a , b ;
    void ext( int[][] nums , int[][] rs ,int i ,int j , int k ) {
        int inter = Integer.MAX_VALUE;
        for( int x = i ; x<i+k ; ++x ){
            for( int y=j ; y<j+k ; ++y ){
                for( int xx = i ; xx<i+k ; ++xx ){
                    for( int yy=j ; yy<j+k ; ++yy ){
                        if( ( x == xx && y == yy ) || nums[x][y] == nums[xx][yy] ){
                            continue ;
                        }
                        inter = Math.min( inter , Math.abs( nums[x][y] - nums[xx][yy] ) ) ;
                    }
                }
            }
        }
        rs[i][j] = inter == Integer.MAX_VALUE ? 0 : inter ;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length ;
        int m = grid[0].length ;
        this.a = n-k+1 ;
        this.b = m-k+1 ;
        int[][] rs = new int[a][b] ;
        for( int i=0 ; i<a ; ++i ){
            for( int j=0 ; j<b ; ++j ){
                ext( grid , rs , i , j , k ) ;
            }
        }
        return rs ;
    }
}