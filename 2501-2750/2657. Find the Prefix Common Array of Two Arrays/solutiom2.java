class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length ; 
        int[] rs = new int[n] ; 
        int[] f = new int[ n+1 ] ; 
        if( A[0] == B[0] ){
            rs[0] = 1 ;
        }else {
            f[ A[0] ]++ ; 
            f[ B[0] ]++ ; 
        }
        for(int i=1 ; i<n ; ++i){
            rs[i] += rs[i-1] ; 
            if( A[i] == B[i] ){
                rs[i]++ ; 
            }else {
                f[ B[i] ]++ ; 
                f[ A[i] ]++ ; 
                if( f[ B[i] ] == 2 ){
                    rs[i]++ ;
                }
                if( f[ A[i] ] == 2 ){
                    rs[i]++ ;
                }
            }
        }

        return rs ; 
    }
}