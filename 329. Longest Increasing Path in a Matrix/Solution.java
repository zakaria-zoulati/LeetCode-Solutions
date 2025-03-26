class Solution {
    int n , m ; 
    static int[][] dirs = { {-1,0} , {1,0} , {0,1} , {0,-1} } ; 
    public int dfs( int[][] matrix , int[][] isVisited , int[][] count , int i , int j ){
        if( isVisited[i][j] == 1 ){
            return count[i][j] ; 
        }
        for( int[] d : dirs ){
            int x = i + d[0] ; 
            int y = j + d[1] ; 
            if( x>=0 && y>=0 && x<n && y<m && matrix[x][y] > matrix[i][j] ){
                count[i][j] = Math.max( count[i][j] , dfs( matrix , isVisited , count , x , y ) ) ; 
            }
        }
        count[i][j]++ ; 
        isVisited[i][j] = 1 ; 
        return count[i][j] ; 
    } 
    public int longestIncreasingPath(int[][] matrix) {
        this.n = matrix.length ; 
        this.m = matrix[0].length ; 
        int[][] count = new int[n][m] ; 
        int[][] isVisited = new int[n][m] ; 

        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( isVisited[i][j] == 0 ){
                    dfs( matrix , isVisited , count , i , j ) ; 
                }
            }
        }
        int rs = -1 ; 
        for( int[] i : count  ){
            for( int j : i ){
                rs = Math.max( rs , j ) ; 
            }
        }
        return rs ; 
    }
}