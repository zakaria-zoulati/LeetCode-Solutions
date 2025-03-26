class Solution {
    int n , m ; 
    int rs ; 
    boolean[][] isVisited ; 
    public int dfs( int[][] matrix , int[][] count , int i , int j ){
        if( isVisited[i][j] ){
            return count[i][j] ; 
        }
        int t = i+1 ; 
        if( t < n && matrix[t][j] > matrix[i][j] ){
            count[i][j] = Math.max( count[i][j] , dfs( matrix , count , t , j ) ) ; 
        }
        t = i-1 ; 
        if( t >= 0 && matrix[t][j] > matrix[i][j] ){
            count[i][j] = Math.max( count[i][j] , dfs( matrix , count , t , j ) ) ; 
        }
        t = j+1 ; 
        if( t < m && matrix[i][t] > matrix[i][j] ){
            count[i][j] = Math.max( count[i][j] , dfs( matrix , count , i , t ) ) ; 
        }
        t = j-1 ; 
        if( t >= 0 && matrix[i][t] > matrix[i][j] ){
            count[i][j] = Math.max( count[i][j] , dfs( matrix , count , i , t ) ) ; 
        }
        count[i][j]++ ; 
        isVisited[i][j] = true ; 
        return count[i][j] ; 
    } 
    public int longestIncreasingPath(int[][] matrix) {
        this.n = matrix.length ; 
        this.m = matrix[0].length ; 
        int[][] count = new int[n][m] ; 
        isVisited = new boolean[n][m] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( !isVisited[i][j] ){
                    rs = Math.max( rs , dfs( matrix , count , i , j  ) ) ; 
                }
            }
        }
        return rs ; 
    }
}