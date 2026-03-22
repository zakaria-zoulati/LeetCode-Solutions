class Solution {
    public void rotate( int[][] mat ){
        int n = mat.length ; 
        int l = 0 ; 
        int r = n-1 ; 
        while( l < r ){
           int len = r - l + 1 ;
            for( int i=0 ; i<len-1 ; ++i ){
                int temp = mat[l][l+i] ; 
                mat[l][l+i] = mat[r-i][l] ; 
                mat[r-i][l] = mat[r][r-i] ; 
                mat[r][r-i] = mat[l+i][r] ;
                mat[l+i][r] = temp ;  
            }
           l++ ; 
           r-- ; 
        }
    }
    public boolean isEqual( int[][] mat , int[][] target ){
        for( int i=0 ; i<mat.length ; ++i ){
            for( int j=0 ; j<mat.length ; ++j ){
                if( mat[i][j] != target[i][j] ) return false ; 
            }
        }
        return true ; 
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        if( isEqual( mat , target ) ) return true ; 
        rotate( mat ) ; 
        if( isEqual( mat , target ) ) return true ; 
        rotate( mat ) ; 
        if( isEqual( mat , target ) ) return true ; 
        rotate( mat ) ; 
        if( isEqual( mat , target ) ) return true ;         
        return false ; 
    }
}