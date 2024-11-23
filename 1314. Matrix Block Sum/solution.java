class solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length ; 
        int n = mat[0].length ; 
        int[][] rs = new int[m][n] ; 
        for( int i=0 ; i<m ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                spread( i , j , mat , rs , k ) ; 
            }
        }
        return rs ; 
    }
    public void spread( int i , int j , int[][] mat , int[][] rs,  int k ){
        int m = mat.length ; 
        int n = mat[0].length ; 
        int a = Math.max( i-k , 0 ) ;
        int b = Math.min( i+k , m-1 ) ; 
        int c = Math.max( j-k , 0 ) ; 
        int d = Math.min( j+k , n-1 ) ; 
        for( int s = a; s <= b ; ++s ){
            for( int e=c ; e<=d ; ++e ){
                rs[s][e] += mat[i][j] ; 
            }
        }
    } 
}