class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length ; 
        int[] rs = new int[n] ; 
        boolean[] f1 = new boolean[ n+1 ] ; 
        boolean[] f2 = new boolean[ n+1 ] ; 
        if( A[0] == B[0] ){
            rs[0] = 1 ;
        }else {
            f1[ A[0] ] = true ; 
            f2[ B[0] ] = true ; 
        }
        for(int i=1 ; i<n ; ++i){
            rs[i] += rs[i-1] ; 
            if( A[i] == B[i] ){
                rs[i]++ ; 
            }else {
                if( f1 [ B[i] ] ){
                    rs[i]++ ;
                }else {
                    f2[ B[i] ] = true ; 
                }
                if( f2[ A[i] ] ){
                    rs[i]++ ;
                }else {
                    f1 [ A[i] ] = true ; 
                }
            }
        }

        return rs ; 
    }
}