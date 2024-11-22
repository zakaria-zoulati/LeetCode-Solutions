class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length ; 
        int n = matrix[0].length ; 
        int rs = 0 ; 
        int[] k = new int[n] ; 
        boolean[] isSeen = new boolean[m] ; 
        for( int i=0 ; i<m ; ++i ){
            if( isSeen[i] ) continue ; 
            isSeen[i] = true ; 
            k = matrix[i] ; 
            int co = 1 ;
            for(int j=0 ; j<m ; ++j){
                if( isSeen[j] ) continue ; 
                boolean flag = true ; 
                int val = matrix[j][0]^k[0] ; 
                for( int t=1 ;t<n ; ++t ){
                    if( (matrix[j][t] ^ k[t]) != val ){
                        flag = false ; 
                        break ; 
                    }
                }
                if( flag ){
                    ++co ; 
                    isSeen[j] = true ;
                }
            }
            if( co > rs ) rs = co ;  
        }
        return rs ; 
    }
}