class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int in = 0 ; 
        int[] rs = new int[n*m] ; 
        if( n == 1 || m == 1 ){
            for( int[] i : mat ){
                for( int j : i ){
                    rs[in++] = j; 
                }
            }
            return rs;  
        }
        boolean flag = false ; 
        for( int i=0 ; i<m ; ++i ){
            if( flag ){
                int x = 0 ; 
                int y = i ; 
                while( x < n && y >= 0 ){
                    rs[in++] = mat[x][y] ; 
                    x++ ; 
                    y-- ; 
                }
            }else {
                int els = Math.min( n-1 , i ) ; 
                int x = els ; 
                int y = i - els; 
                while( x >= 0 && y < m ){
                    rs[in++] = mat[x][y] ; 
                    x-- ; 
                    y++ ; 
                }  
            }
            flag = !flag ; 
        }
        for( int i=1 ; i<n ; ++i ){
            if( flag ){
                int x = i ; 
                int y = m-1 ; 
                while( x < n && y >= 0 ){
                    rs[in++] = mat[x][y] ; 
                    x++ ; 
                    y-- ; 
                }
            }else {
                int els = Math.min( n-1 - i , m-1 ) ;  
                int x = i + els ; 
                int y = m-1 - els ; 
                while( x >= 0 && y < m ){
                    rs[in++] = mat[x][y] ; 
                    x-- ; 
                    y++ ; 
                }  
            }
            flag = !flag ; 
        }
        return rs ; 
    }
}