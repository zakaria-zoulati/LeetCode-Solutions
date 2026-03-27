class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        if( k==0 ) return true ; 
        int n = mat.length ; 
        int m = mat[0].length ;
        k %= m ;   
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( mat[i][(j+k)%m] != mat[i][j] ) return false ; 
            }
        }
        return true ; 
    }
}