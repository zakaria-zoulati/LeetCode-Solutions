class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length ; 
        int n = mat[0].length ; 
        for( int i=0;i<m ; ++i ){
            for( int j=1 ;j<n ; ++j ){
                mat[i][j] += mat[i][j-1] ; 
            }
        }
        for( int i=0 ; i<m-1 ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                mat[i+1][j] += mat[i][j] ; 
            }
        }
        int[][] rs = new int[m][n] ; 
        for( int i=0 ; i<m ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                comp( i , j , mat , rs , k ) ; 
            }
        }
        return rs ; 
    }
    public void comp( int i , int j , int[][] mat , int[][] rs,  int k ){
        int m = mat.length ; 
        int n = mat[0].length ; 
        int a = Math.max( i-k , 0 ) ;
        int b = Math.min( i+k , m-1 ) ; 
        int c = Math.max( j-k , 0 ) ; 
        int d = Math.min( j+k , n-1 ) ; 
        int diff = ( c-1>=0 ? mat[b][c-1] : 0 ) + ( a-1>=0 ? mat[a-1][d] : 0 ) - ( a-1>=0 && c-1>=0 ? mat[a-1][c-1] : 0 ) ; 
        rs[i][j] = mat[b][d] - diff ; 
    } 
}